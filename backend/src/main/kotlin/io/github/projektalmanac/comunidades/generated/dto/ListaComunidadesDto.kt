package io.github.projektalmanac.comunidades.generated.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.projektalmanac.comunidades.generated.dto.DetallesComunidadDto
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
 * @param comunidades 
 */
data class ListaComunidadesDto(

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("comunidades", required = true) val comunidades: kotlin.collections.List<DetallesComunidadDto>
) {

}

