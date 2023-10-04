package io.github.projektalmanac.comunidades.controller

import io.github.projektalmanac.comunidades.generated.api.UsuariosApi
import io.github.projektalmanac.comunidades.generated.dto.CreacionUsuarioDto
import io.github.projektalmanac.comunidades.generated.dto.UsuarioCreadoDto
import org.springframework.http.ResponseEntity

class UsuariosController: UsuariosApi {
    override fun crearUsuario(creacionUsuarioDto: CreacionUsuarioDto?): ResponseEntity<UsuarioCreadoDto> {
        TODO("Not yet implemented")
    }
}