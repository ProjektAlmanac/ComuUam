package io.github.projektalmanac.comunidades.generated.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param idComunidad 
 * @param nombre 
 * @param descricion 
 * @param categoria 
 * @param tipo 
 */
data class ComunidadDto(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("idComunidad", required = true) val idComunidad: kotlin.Int,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("nombre", required = true) val nombre: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("descricion", required = true) val descricion: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("categoria", required = true) val categoria: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("tipo", required = true) val tipo: kotlin.String
) {

}

