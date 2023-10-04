package io.github.projektalmanac.comunidades.service

import io.github.projektalmanac.comunidades.controller.UsuariosController
import io.github.projektalmanac.comunidades.entity.Comunidad
import io.github.projektalmanac.comunidades.exception.CommunityNotFoundException
import io.github.projektalmanac.comunidades.exception.UserNotFoundException
import io.github.projektalmanac.comunidades.generated.dto.ComunidadDto
import io.github.projektalmanac.comunidades.generated.dto.IdUsuarioDto

import io.github.projektalmanac.comunidades.generated.dto.ListaComunidadesDto

import io.github.projektalmanac.comunidades.generated.dto.*
import io.github.projektalmanac.comunidades.mapper.ComunidadMapper
import io.github.projektalmanac.comunidades.repository.ComunidadRepository
import io.github.projektalmanac.comunidades.repository.UserRepository
import org.slf4j.LoggerFactory

import io.github.projektalmanac.comunidades.generated.dto.ComunidadCreadaDto
import io.github.projektalmanac.comunidades.generated.dto.CreacionComunidadDto

import org.springframework.stereotype.Service
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.Jwt

@Service
class ComunidadService(
    private val comunidadRepository: ComunidadRepository,
    private val userRepository: UserRepository,
    private val usuariosController: UsuariosController
) {

    fun getInfoComunidad(idComunidad: Any): ComunidadDto {
        LOGGER.info(">> getInfoComunidad {}", idComunidad)
        val idComunidadInt: Int? = (idComunidad as? Int)?.toInt() ?: throw IllegalArgumentException("Error, parceo incorrecto")
        val comunidad = comunidadRepository.findComunidadById(idComunidadInt) ?: throw CommunityNotFoundException(idComunidadInt!!)
        val comunidadDto = ComunidadMapper.INSTANCE.comunidadToDto(comunidad)?: throw IllegalArgumentException("Error, el mapeo de entidad no fue exitoso")
        LOGGER.info("<< getInfoComunidad {}", idComunidad)
        return comunidadDto
    }

    fun agregaMiembroComunidad(idComunidad: Any, usuarioDto: IdUsuarioDto?) {
        LOGGER.info(">> agregaMiembroComunidad {}", idComunidad)
        val idComunidadInt: Int? = (idComunidad as? Int)?.toInt() ?: throw IllegalArgumentException("Error, parceo incorrecto")
        val comunidad = comunidadRepository.findComunidadById(idComunidadInt) ?: throw CommunityNotFoundException(idComunidadInt!!)
        val usuario = usuarioDto?.idUsuario?.let { userRepository.findUserByIdUser(it) }

        if (usuario == null) if (usuarioDto != null) {
            throw UserNotFoundException(usuarioDto.idUsuario)
        }

        if (usuario != null) {
            comunidad.usuariosInscritos.add(usuario)
        }
        val comuActualizada: Comunidad = comunidadRepository.save(comunidad)!!
        if (comuActualizada == null) throw CommunityNotFoundException(idComunidad)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ComunidadService::class.java)
    }

    fun crearComunidad(creacionComunidadDto: CreacionComunidadDto?, authentication: Authentication): ComunidadCreadaDto {
        val principal = authentication.principal
        require(principal is Jwt)
        val email = principal.claims["email"] as String
        val usuario = userRepository.findByCorreo(email)
        val comunidad: Comunidad? = creacionComunidadDto?.let { ComunidadMapper.INSTANCE.toComunidad(it) }
        comunidad?.let { comunidadRepository?.save(it) }
        comunidad?.let { usuario?.agregarComunidad(it) }
        usuario?.let { userRepository?.save(it) }
        //comunidad = comunidadRepository.findById(book.getIsbn())
        //return toLibroRegistradoDto(book)
        TODO("Not yet implemented")
    }

    fun recuperaTodasLasComunidades(): ListaComunidadesDto {

        val comunidadesRecuperadas = comunidadRepository.findAll()

        val listaComunidades: MutableList<DetallesComunidadDto> = mutableListOf()

        for (comunidad in comunidadesRecuperadas) {

            val creadoPorVariable = CreadorComunidadDto (
                id = comunidad?.dueno?.idUser!!,
                nombre = comunidad.dueno.name + " " + comunidad.dueno.lastName,
            )

            val detalleComunidad = DetallesComunidadDto (
                nombre = comunidad.nombre!!,
                descripcion = comunidad.descripcion!!,
                creadoPor = creadoPorVariable,
            )
            listaComunidades.add(detalleComunidad)
        }
        val listaComunidadesDto = ListaComunidadesDto (comunidades = listaComunidades)
        LOGGER.info("Recuperando todas las comunidades registradas")
        return listaComunidadesDto
    }
}
