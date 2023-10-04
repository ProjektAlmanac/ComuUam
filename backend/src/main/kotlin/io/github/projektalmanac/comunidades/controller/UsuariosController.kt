package io.github.projektalmanac.comunidades.controller

import io.github.projektalmanac.comunidades.generated.api.UsuariosApi
import io.github.projektalmanac.comunidades.generated.dto.CreacionUsuarioDto
import io.github.projektalmanac.comunidades.generated.dto.IdUsuarioDto
import io.github.projektalmanac.comunidades.generated.dto.ListaComunidadesDto
import io.github.projektalmanac.comunidades.generated.dto.UsuarioCreadoDto
import io.github.projektalmanac.comunidades.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RestController

@RestController
class UsuariosController(private val userService: UserService): UsuariosApi {
    override fun crearUsuario(creacionUsuarioDto: CreacionUsuarioDto?): ResponseEntity<UsuarioCreadoDto> {
        val usuarioCreadoDto = userService.crearUsuario(creacionUsuarioDto!!)
        return ResponseEntity.ok(usuarioCreadoDto)
    }

    override fun getComunidadesUsuario(id: Any): ResponseEntity<ListaComunidadesDto> {
        val idInt = Integer.parseInt(id.toString())
        val comunidades = userService.getComunidadesUsuario(idInt)
        return ResponseEntity.ok(comunidades)
    }

    override fun getId(): ResponseEntity<IdUsuarioDto> {
        val authentication = SecurityContextHolder.getContext().authentication
        val user = userService.getUser(authentication)
        val id =
            if (user === null) {
                val createdUser = userService.crearUsuario(authentication)
                createdUser.idUser!!
            }
            else
                user.idUser!!

        return ResponseEntity.ok(IdUsuarioDto(id))
    }
}