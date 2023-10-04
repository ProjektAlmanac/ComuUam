package io.github.projektalmanac.comunidades.service

import io.github.projektalmanac.comunidades.entity.Comunidad
import io.github.projektalmanac.comunidades.exception.CommunityNotFoundException
import io.github.projektalmanac.comunidades.exception.UserNotFoundException
import io.github.projektalmanac.comunidades.generated.dto.ComunidadDto
import io.github.projektalmanac.comunidades.generated.dto.IdUsuarioDto
import io.github.projektalmanac.comunidades.generated.dto.ListaComunidadesDto
import io.github.projektalmanac.comunidades.mapper.ComunidadMapper
import io.github.projektalmanac.comunidades.repository.ComunidadRepository
import io.github.projektalmanac.comunidades.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

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
        val usuario = usuarioDto?.idUsuario?.let { userRepository.findUserById(it) }

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
}
