package io.github.projektalmanac.comunidades.mapper

import io.github.projektalmanac.comunidades.entity.Comunidad
import io.github.projektalmanac.comunidades.generated.dto.ComunidadDto
import io.github.projektalmanac.comunidades.generated.dto.CreacionComunidadDto
import io.github.projektalmanac.comunidades.generated.dto.ListaComunidadesDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring")
interface ComunidadMapper {
    @Mapping(source = "descripcion", target = "descricion" )
    @Mapping(source = "visibilidad", target = "tipo" )
    @Mapping(source = "id", target = "idComunidad")
    fun comunidadToDto(comunidad: Comunidad): ComunidadDto

    fun toComunidad(creacionComunidadDto: CreacionComunidadDto): Comunidad

    fun listComunidadToListDto(listComunidad: List<Comunidad>): List<ListaComunidadesDto>

}