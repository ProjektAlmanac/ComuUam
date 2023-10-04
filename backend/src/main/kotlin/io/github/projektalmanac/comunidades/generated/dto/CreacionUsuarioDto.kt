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
 * Datos necesarios para crear un usuario
 * @param nombre 
 * @param apellidos 
 * @param correo 
 * @param password 
 */
data class CreacionUsuarioDto(

    @Schema(example = "null", description = "")
    @get:JsonProperty("nombre") val nombre: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("apellidos") val apellidos: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("correo") val correo: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("password") val password: kotlin.String? = null
) {

}

