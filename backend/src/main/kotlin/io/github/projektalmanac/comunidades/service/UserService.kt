package io.github.projektalmanac.comunidades.service

import io.github.projektalmanac.comunidades.entity.User
import io.github.projektalmanac.comunidades.exception.UserAlreadyExistsException
import io.github.projektalmanac.comunidades.exception.UserNotFoundException
import io.github.projektalmanac.comunidades.generated.dto.CreacionUsuarioDto
import io.github.projektalmanac.comunidades.generated.dto.IdUsuarioDto
import io.github.projektalmanac.comunidades.generated.dto.ListaComunidadesDto
import io.github.projektalmanac.comunidades.generated.dto.UsuarioCreadoDto
import io.github.projektalmanac.comunidades.mapper.ComunidadMapper
import io.github.projektalmanac.comunidades.mapper.UserMapper
import io.github.projektalmanac.comunidades.repository.ComunidadRepository
import io.github.projektalmanac.comunidades.repository.UserRepository

import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Service



@Service
class UserService (private val userRepository: UserRepository, private val comunidadRepository: ComunidadRepository, private val comunidadMapper: ComunidadMapper) {


    fun agregaMiembroComunidad(idComunidad: Int?, usuarioDto: IdUsuarioDto?) {}

    fun getUser(authentication: Authentication): User? {
        val principal = authentication.principal
        require(principal is Jwt)
        val email = principal.claims["email"] as String
        return userRepository.findByCorreo(email)
    }

    fun crearUsuario(creacionUsuarioDto: CreacionUsuarioDto): UsuarioCreadoDto {
        val usuario = userRepository.findByCorreo(creacionUsuarioDto.correo)
        if (usuario !== null) {
            LOGGER.warn("Usuario ya existe")
            throw UserAlreadyExistsException(creacionUsuarioDto.correo)
        }
        var userEntity = UserMapper.INSTANCE.toEntity(creacionUsuarioDto)
        userEntity = userRepository.save(userEntity)
        LOGGER.info("Usuario creado con id ${userEntity.idUser}")
        return UserMapper.INSTANCE.toDto(userEntity)
    }

    fun crearUsuario(authentication: Authentication): User {
        val principal = authentication.principal
        require(principal is Jwt)
        val email = principal.claims["email"] as String
        val usuario = userRepository.findByCorreo(email)
        usuario?.let {
            LOGGER.info("Usuario ya existe")
            throw UserAlreadyExistsException(email)
        }
        var user = User()
        user.correo = email
        user = userRepository.save(user)
        LOGGER.info("Usuario creado con id ${user.idUser}")
        return user
    }

    fun getComunidadesUsuario(id: Int): ListaComunidadesDto {
        val user = userRepository.findUserByIdUser(id) ?: throw UserNotFoundException(id)
        val comunidades = user.comunidad
        return comunidadMapper.toListaComunidadesDto(comunidades)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(UserService::class.java)
    }

}
