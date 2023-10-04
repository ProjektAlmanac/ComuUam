package io.github.projektalmanac.comunidades.generated.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.projektalmanac.comunidades.generated.dto.CreadorComunidadDto
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
 * @param nombre 
 * @param creadoPor 
 * @param descripcion 
 * @param id 
 */
data class DetallesComunidadDto(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("nombre", required = true) val nombre: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("creadoPor", required = true) val creadoPor: CreadorComunidadDto,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("descripcion", required = true) val descripcion: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("id", required = true) val id: kotlin.Int
) {

}

