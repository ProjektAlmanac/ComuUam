package io.github.projektalmanac.comunidades.comunidades

import io.github.projektalmanac.comunidades.controller.UsuariosController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
@ComponentScan(basePackageClasses = [UsuariosController::class])
class ComunidadesApplication

fun main(args: Array<String>) {
	runApplication<ComunidadesApplication>(*args)
}
