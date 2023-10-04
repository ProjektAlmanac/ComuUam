package io.github.projektalmanac.comunidades.controller

import io.github.projektalmanac.comunidades.generated.api.UsuariosApi
import io.github.projektalmanac.comunidades.generated.dto.CreacionUsuarioDto
import io.github.projektalmanac.comunidades.generated.dto.IdUsuarioDto
import io.github.projektalmanac.comunidades.generated.dto.UsuarioCreadoDto
import io.github.projektalmanac.comunidades.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RestController

@RestController
class UsuariosController(private val userService: UserService): UsuariosApi {
    override fun crearUsuario(creacionUsuarioDto: CreacionUsuarioDto?): ResponseEntity<UsuarioCreadoDto> {
        TODO("Not yet implemented")
    }

    override fun getId(): ResponseEntity<IdUsuarioDto> {
        val authentication = SecurityContextHolder.getContext().authentication
        val userId = userService.getId(authentication)
        if (userId === null)
            TODO("Añadir al usuario")
        return ResponseEntity.ok(IdUsuarioDto(userId))
    }
}