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
    private val comunidadMapper: ComunidadMapper
) {

    fun getInfoComunidad(idComunidad: Any): ComunidadDto {
        LOGGER.info(">> getInfoComunidad {}", idComunidad)
        val idComunidadInt = Integer.parseInt(idComunidad.toString())
        val comunidad = comunidadRepository.findComunidadById(idComunidadInt) ?: throw CommunityNotFoundException(idComunidadInt)
        val comunidadDto = comunidadMapper.comunidadToDto(comunidad)
        LOGGER.info("<< getInfoComunidad {}", idComunidad)
        return comunidadDto
    }

    fun agregaMiembroComunidad(idComunidad: Any, usuarioDto: IdUsuarioDto?) {
        LOGGER.info("> agregaMiembroComunidad {}", idComunidad)
        val idComunidadInt = Integer.parseInt(idComunidad.toString())
        val comunidad = comunidadRepository.findComunidadById(idComunidadInt) ?: throw CommunityNotFoundException(idComunidadInt)
        val usuario = usuarioDto?.idUsuario?.let { userRepository.findUserByIdUser(it) }
            ?: throw UserNotFoundException(usuarioDto?.idUsuario!!)

        comunidad.usuariosInscritos.add(usuario)

        comunidadRepository.save(comunidad)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ComunidadService::class.java)
    }

    fun crearComunidad(creacionComunidadDto: CreacionComunidadDto?, authentication: Authentication): ComunidadCreadaDto {
        requireNotNull(creacionComunidadDto)
        val principal = authentication.principal
        require(principal is Jwt)
        val email = principal.claims["email"] as String
        val usuario = userRepository.findByCorreo(email) ?: throw UserNotFoundException(-1)
        var comunidad  =  comunidadMapper.toComunidad(creacionComunidadDto)
        comunidad.dueno = usuario
        usuario.agregarComunidad(comunidad)
        comunidad = comunidadRepository.save(comunidad)
        userRepository.save(usuario)
        return comunidadMapper.toComunidadCreadaDto(comunidad)
    }

    fun recuperaTodasLasComunidades(): ListaComunidadesDto {

        val comunidadesRecuperadas = comunidadRepository.findAll()

        val listaComunidades: MutableList<DetallesComunidadDto> = mutableListOf()

        for (comunidad in comunidadesRecuperadas) {

            val creadoPorVariable = CreadorComunidadDto (
                id = comunidad?.dueno?.idUser!!,
                nombre = comunidad.dueno!!.name + " " + comunidad.dueno!!.lastName,
            )

            val detalleComunidad = DetallesComunidadDto (
                nombre = comunidad.nombre!!,
                descripcion = comunidad.descripcion!!,
                creadoPor = creadoPorVariable,
                id = comunidad.id ?: 0,
                descripcionCorta = comunidad.descripcionCorta!!,
            )
            listaComunidades.add(detalleComunidad)
        }
        val listaComunidadesDto = ListaComunidadesDto (comunidades = listaComunidades)
        LOGGER.info("Recuperando todas las comunidades registradas")
        return listaComunidadesDto
    }
}
