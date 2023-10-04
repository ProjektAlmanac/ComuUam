package io.github.projektalmanac.comunidades.controller

import io.github.projektalmanac.comunidades.generated.api.ComunidadApi
import io.github.projektalmanac.comunidades.generated.dto.*
import io.github.projektalmanac.comunidades.service.ComunidadService
import io.github.projektalmanac.comunidades.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
class ComunidadController(private val comunidadService: ComunidadService,private val userService: UserService): ComunidadApi {

    override fun agregarMiembroComunidad(idComunidad: Any, idUsuarioDto: IdUsuarioDto?): ResponseEntity<Unit> {
        comunidadService.agregaMiembroComunidad(idComunidad,idUsuarioDto)
        return ResponseEntity.accepted().build()
    }

    override fun crearComunidad(creacionComunidadDto: CreacionComunidadDto?): ResponseEntity<ComunidadCreadaDto> {
        val authentication = SecurityContextHolder.getContext().authentication
        val result = comunidadService.crearComunidad(creacionComunidadDto, authentication)
        return ResponseEntity.status(HttpStatus.CREATED).body(result)
    }

    override fun getComunidades(): ResponseEntity<ListaComunidadesDto> {
        val result = comunidadService.recuperaTodasLasComunidades()
        return ResponseEntity.ok(result)
    }

    override fun getInfoComunidad(idComunidad: Any): ResponseEntity<ComunidadDto> {
        val comInfo: ComunidadDto = comunidadService.getInfoComunidad(idComunidad)
        return ResponseEntity.ok(comInfo)
    }
}