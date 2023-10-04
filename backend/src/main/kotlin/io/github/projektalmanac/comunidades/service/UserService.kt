package io.github.projektalmanac.comunidades.service

import io.github.projektalmanac.comunidades.exception.CommunityNotFoundException
import io.github.projektalmanac.comunidades.exception.UserNotFoundException
import io.github.projektalmanac.comunidades.generated.dto.ComunidadDto
import io.github.projektalmanac.comunidades.generated.dto.IdUsuarioDto
import io.github.projektalmanac.comunidades.mapper.ComunidadMapper.Companion.INSTANCE
import io.github.projektalmanac.comunidades.repository.ComunidadRepository
import io.github.projektalmanac.comunidades.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepository: UserRepository, private val comunidadRepository: ComunidadRepository) {
    fun getInfoComunidad(idComunidad: Any): ComunidadDto {
        LOGGER.info(">> getInfoComunidad {}", idComunidad)
        val idComunidadInt: Int? = (idComunidad as? Int)?.toInt() ?: throw IllegalArgumentException("Error, parceo incorrecto")
        val comunidad = comunidadRepository.findComunidadById(idComunidadInt) ?: throw CommunityNotFoundException(idComunidadInt!!)
        val comunidadDto = INSTANCE.comunidadToDto(comunidad)?: throw IllegalArgumentException("Error, el mapeo de entidad no fue exitoso")
        LOGGER.info("<< getInfoComunidad {}", idComunidad)
        return comunidadDto
    }

    fun agregaMiembroComunidad(idComunidad: Any, usuarioDto: IdUsuarioDto?) {
        LOGGER.info(">> agregaMiembroComunidad {}", idComunidad)
        val idComunidadInt: Int? = (idComunidad as? Int)?.toInt() ?: throw IllegalArgumentException("Error, parceo incorrecto")
        val comunidad = comunidadRepository.findComunidadById(idComunidadInt) ?: throw CommunityNotFoundException(idComunidadInt!!)
        val usuario = usuarioDto?.let {
            val usuarioEncontrado = userRepository.findById(it.idUsuario)
            if (usuarioEncontrado == null) {
                throw UserNotFoundException(it.idUsuario)
            }
            usuarioEncontrado
        }



    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(UserService::class.java)
    }
}
