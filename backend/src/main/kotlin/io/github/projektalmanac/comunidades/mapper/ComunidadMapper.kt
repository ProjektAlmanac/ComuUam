package io.github.projektalmanac.comunidades.mapper

import io.github.projektalmanac.comunidades.entity.Comunidad
import io.github.projektalmanac.comunidades.generated.dto.ComunidadCreadaDto
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

    @Mapping(target = "categorias", expression = "java(new ArrayList<>())")
    fun toComunidadCreadaDto(comunidad: Comunidad): ComunidadCreadaDto

    fun listComunidadToListDto(listComunidad: List<Comunidad>): List<ListaComunidadesDto>

}