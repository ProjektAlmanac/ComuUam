package io.github.projektalmanac.comunidades.controller

import io.github.projektalmanac.comunidades.generated.api.ComunidadApi
import io.github.projektalmanac.comunidades.generated.dto.*
import io.github.projektalmanac.comunidades.service.ComunidadService
import io.github.projektalmanac.comunidades.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController


@RestController
class ComunidadController(private val comunidadService: ComunidadService): ComunidadApi {
    override fun agregarMiembroComunidad(idComunidad: Any, idUsuarioDto: IdUsuarioDto?): ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }

    override fun crearComunidad(creacionComunidadDto: CreacionComunidadDto?): ResponseEntity<ComunidadCreadaDto> {
        TODO("Not yet implemented")
    }

    override fun getComunidades(): ResponseEntity<ListaComunidadesDto> {
        TODO("Not yet implemented")
    }

    override fun getInfoComunidad(idComunidad: Any): ResponseEntity<ComunidadDto> {

        TODO("Not yet implemented")
    }
}