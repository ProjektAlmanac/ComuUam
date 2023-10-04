package io.github.projektalmanac.comunidades.service

import io.github.projektalmanac.comunidades.exception.CommunityNotFoundException
import io.github.projektalmanac.comunidades.generated.dto.ComunidadDto
import io.github.projektalmanac.comunidades.generated.dto.IdUsuarioDto
import io.github.projektalmanac.comunidades.mapper.ComunidadMapper.Companion.INSTANCE
import io.github.projektalmanac.comunidades.repository.ComunidadRepository
import io.github.projektalmanac.comunidades.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepository: UserRepository, private val comunidadRepository: ComunidadRepository) {
    fun getInfoComunidad(id: Int?): ComunidadDto {
        LOGGER.info(">> getInfoComunidad {}", id)
        val comunidad = comunidadRepository.findComunidadById(id) ?: throw CommunityNotFoundException(id!!)
        val comunidadDto = INSTANCE.comunidadToDto(comunidad)
            ?: throw IllegalArgumentException("Erro, el mapeo de entidad no fue exitoso")
        LOGGER.info("<< getInfoComunidad {}", id)
        return comunidadDto
    }

    fun agregaMiembroComunidad(idComunidad: Int?, usuarioDto: IdUsuarioDto?) {}

    fun getId(authentication: Authentication): Int? {
        val principal = authentication.principal
        require(principal is Jwt)
        val email = principal.claims["email"] as String
        val usuario = userRepository.findByCorreo(email)
        if (usuario === null) return null
        requireNotNull(usuario.idUser)
        return usuario.idUser
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(UserService::class.java)
    }
}
