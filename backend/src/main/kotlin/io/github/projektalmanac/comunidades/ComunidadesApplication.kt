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

	fun init() {
		val user = User()

		user.name = "Juan"
		user.lastName = "Perez"
		user.correo = "juan.perez@titlani.uam.mx"

		val user2 = User()
		user2.name = "Alan"
		user2.lastName = "Turing"
		user2.correo = "user@test.com"

		val user3 = User()
		user3.name = "Antar"
		user3.lastName = "Espadas"
		user3.correo = "espadas.antar@gmail.com"

		val comunidad = Comunidad()
		comunidad.nombre = "Comunidad de prueba"
		comunidad.descripcion = "Comunidad de prueba"
		comunidad.dueno = user
		comunidad.visibilidad = "publica"
		comunidad.categoria = "prueba"
		comunidad.descripcionCorta = "prueba"

		val comunidad2 = Comunidad()
		comunidad2.nombre = "Comunidad de prueba 2"
		comunidad2.descripcion = "Comunidad de prueba 2"
		comunidad2.dueno = user
		comunidad2.visibilidad = "publica"
		comunidad2.categoria = "prueba 2"
		comunidad2.descripcionCorta = "prueba 2"

		user.dueno.add(comunidad)
		user.dueno.add(comunidad2)

		user3.comunidad.add(comunidad)
		user3.comunidad.add(comunidad2)

		comunidad.usuariosInscritos.add(user3)
		comunidad2.usuariosInscritos.add(user3)

		userRepository.save(user)
		userRepository.save(user2)
		userRepository.save(user3)

		comunidadRepository.save(comunidad)
		comunidadRepository.save(comunidad2)
	}
}
fun main(args: Array<String>) {
	runApplication<ComunidadesApplication>(*args)
}