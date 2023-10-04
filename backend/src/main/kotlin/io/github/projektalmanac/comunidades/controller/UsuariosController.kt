package io.github.projektalmanac.comunidades.controller

import io.github.projektalmanac.comunidades.generated.api.UsuariosApi
import io.github.projektalmanac.comunidades.generated.dto.CreacionUsuarioDto
import io.github.projektalmanac.comunidades.generated.dto.IdUsuarioDto
import io.github.projektalmanac.comunidades.generated.dto.UsuarioCreadoDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UsuariosController: UsuariosApi {
    override fun crearUsuario(creacionUsuarioDto: CreacionUsuarioDto?): ResponseEntity<UsuarioCreadoDto> {
        TODO("Not yet implemented")
    }

    override fun getId(): ResponseEntity<IdUsuarioDto> {
        TODO("Not yet implemented")
    }
}