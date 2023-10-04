package io.github.projektalmanac.comunidades.controller

import io.github.projektalmanac.comunidades.generated.api.ComunidadApi
import io.github.projektalmanac.comunidades.generated.dto.ComunidadDto
import io.github.projektalmanac.comunidades.generated.dto.IdUsuarioDto
import io.github.projektalmanac.comunidades.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity

class ComunidadController constructor(private val userService:UserService): ComunidadApi {


    override fun agregarMiembroComunidad(idComunidad: Any, idUsuarioDto: IdUsuarioDto?): ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }

    override fun getInfoComunidad(idComunidad: Any): ResponseEntity<ComunidadDto> {
        val idComunidadInt: Int? = (idComunidad as? Int)?.toInt()
        return  ResponseEntity.

    }
}