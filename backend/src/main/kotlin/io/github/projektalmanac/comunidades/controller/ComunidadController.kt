package io.github.projektalmanac.comunidades.controller

import io.github.projektalmanac.comunidades.generated.api.ComunidadApi
import io.github.projektalmanac.comunidades.generated.dto.ComunidadDto
import io.github.projektalmanac.comunidades.generated.dto.IdUsuarioDto
import org.springframework.http.ResponseEntity

class ComunidadController: ComunidadApi {
    override fun agregarMiembroComunidad(idComunidad: Any, idUsuarioDto: IdUsuarioDto?): ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }

    override fun getInfoComunidad(idComunidad: Any): ResponseEntity<ComunidadDto> {
        TODO("Not yet implemented")
    }
}