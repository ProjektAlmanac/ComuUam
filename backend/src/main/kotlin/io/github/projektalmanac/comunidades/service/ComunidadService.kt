package io.github.projektalmanac.comunidades.service

import io.github.projektalmanac.comunidades.entity.Comunidad
import io.github.projektalmanac.comunidades.exception.CommunityNotFoundException
import io.github.projektalmanac.comunidades.exception.UserNotFoundException
import io.github.projektalmanac.comunidades.generated.dto.ComunidadDto
import io.github.projektalmanac.comunidades.generated.dto.IdUsuarioDto

import io.github.projektalmanac.comunidades.generated.dto.ListaComunidadesDto
import io.github.projektalmanac.comunidades.repository.ComunidadRepository
import io.github.projektalmanac.comunidades.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity

import io.github.projektalmanac.comunidades.entity.User
import io.github.projektalmanac.comunidades.generated.dto.ComunidadCreadaDto
import io.github.projektalmanac.comunidades.generated.dto.CreacionComunidadDto
import io.github.projektalmanac.comunidades.mapper.ComunidadMapper

import org.springframework.stereotype.Service
import io.github.projektalmanac.comunidades.repository.*
import org.springframework.beans.factory.annotation.Autowired

@Service
class ComunidadService(private val comunidadRepository: ComunidadRepository, private val userRepository: UserRepository) {

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

    fun crearComunidad(creacionComunidadDto: CreacionComunidadDto?): ComunidadCreadaDto {
        //val user: User = userRepository.findById(id)
        val comunidad: Comunidad? = creacionComunidadDto?.let { ComunidadMapper.INSTANCE.toComunidad(it) }
        comunidad?.let { comunidadRepository?.save(it) }
        //user.addBook(book)
        //userRepository.save(user)
        //book = bookRepository.findByIsbn(book.getIsbn())
        //return toLibroRegistradoDto(book)
        TODO("Not yet implemented")

    }
}
