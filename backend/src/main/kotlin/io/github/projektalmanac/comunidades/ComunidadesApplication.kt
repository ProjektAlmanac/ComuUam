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
	@PostConstruct
	fun init() {
		var user = User()

		user.name = "Juan"
		user.lastName = "Perez"
		user.correo = "juan.perez@titlani.uam.mx"

		var comunidad = Comunidad()
		comunidad.nombre = "Comunidad de prueba"
		comunidad.descripcion = "Comunidad de prueba"
		comunidad.dueno = user
		comunidad.visibilidad = "publica"
		comunidad.categoria = "prueba"

		var comunidad2 = Comunidad()
		comunidad2.nombre = "Comunidad de prueba 2"
		comunidad2.descripcion = "Comunidad de prueba 2"
		comunidad2.dueno = user
		comunidad2.visibilidad = "publica"
		comunidad2.categoria = "prueba 2"


		userRepository.save(user)
		comunidadRepository.save(comunidad)
		comunidadRepository.save(comunidad2)
	}
}

fun main(args: Array<String>) {
	runApplication<ComunidadesApplication>(*args)
}