package io.github.projektalmanac.comunidades.mapper

import io.github.projektalmanac.comunidades.entity.Comunidad
import io.github.projektalmanac.comunidades.generated.dto.*
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring", uses = [UserMapper::class])
abstract class ComunidadMapper {
    @Mapping(source = "descripcion", target = "descricion" )
    @Mapping(source = "visibilidad", target = "tipo" )
    @Mapping(source = "id", target = "idComunidad")
    @Mapping(target = "categoria", defaultValue = "")
    abstract fun comunidadToDto(comunidad: Comunidad): ComunidadDto

    abstract fun toComunidad(creacionComunidadDto: CreacionComunidadDto): Comunidad

    @Mapping(target = "categorias", expression = "java(new ArrayList<>())")
    abstract fun toComunidadCreadaDto(comunidad: Comunidad): ComunidadCreadaDto

    abstract fun listComunidadToListDto(listComunidad: List<Comunidad>): List<ListaComunidadesDto>

    @Mapping(source = "dueno", target = "creadoPor")
    abstract fun toDetallesComunidadDto(comunidad: Comunidad): DetallesComunidadDto

    fun toListaComunidadesDto(comunidades: List<Comunidad>): ListaComunidadesDto {
        val detalles = comunidades.map { toDetallesComunidadDto(it) }
        return ListaComunidadesDto(detalles)
    }
}