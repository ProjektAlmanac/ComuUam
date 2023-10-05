package io.github.projektalmanac.comunidades.generated.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import io.github.projektalmanac.comunidades.generated.dto.VisibilidadDto
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
 * Datos necesarios para crear una comunidad
 * @param visibilidad 
 * @param descripcion 
 * @param categorias 
 * @param nombre 
 * @param descripcionCorta 
 */
data class CreacionComunidadDto(

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("visibilidad", required = true) val visibilidad: VisibilidadDto,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("descripcion", required = true) val descripcion: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("categorias", required = true) val categorias: kotlin.collections.List<kotlin.String>,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("nombre", required = true) val nombre: kotlin.String,

    @Schema(example = "null", description = "")
    @get:JsonProperty("descripcionCorta") val descripcionCorta: kotlin.String? = null
) {

}

