package io.github.projektalmanac.comunidades.mapper

import io.github.projektalmanac.comunidades.entity.Comunidad
import io.github.projektalmanac.comunidades.generated.dto.ComunidadDto
import io.github.projektalmanac.comunidades.generated.dto.CreacionComunidadDto
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface ComunidadMapper {
    companion object {
        val INSTANCE = Mappers.getMapper(ComunidadMapper::class.java);
    }

    fun comunidadToDto(comunidad: Comunidad): ComunidadDto

    fun toComunidad(creacionComunidadDto: CreacionComunidadDto): Comunidad
}