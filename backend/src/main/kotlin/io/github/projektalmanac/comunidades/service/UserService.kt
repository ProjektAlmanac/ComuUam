package io.github.projektalmanac.comunidades.service

import io.github.projektalmanac.comunidades.entity.Comunidad
import io.github.projektalmanac.comunidades.mapper.ComunidadMapper.Companion.INSTANCE
import io.github.projektalmanac.comunidades.repository.ComunidadRepository
import io.github.projektalmanac.comunidades.repository.UserRepository
import org.springframework.stereotype.Service



@Service
class UserService (private val userRepository: UserRepository, private val comunidadRepository: ComunidadRepository) {

}
