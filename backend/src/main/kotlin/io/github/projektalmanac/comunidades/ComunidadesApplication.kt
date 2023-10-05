package io.github.projektalmanac.comunidades

import io.github.projektalmanac.comunidades.controller.UsuariosController
import io.github.projektalmanac.comunidades.entity.Comunidad
import io.github.projektalmanac.comunidades.entity.User
import io.github.projektalmanac.comunidades.repository.ComunidadRepository
import io.github.projektalmanac.comunidades.repository.UserRepository
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class ComunidadesApplication (private val userRepository: UserRepository, private val comunidadRepository: ComunidadRepository){

}
fun main(args: Array<String>) {
	runApplication<ComunidadesApplication>(*args)
}