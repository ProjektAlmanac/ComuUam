package io.github.projektalmanac.comunidades.mapper

import io.github.projektalmanac.comunidades.entity.User
import io.github.projektalmanac.comunidades.generated.dto.CreacionUsuarioDto
import io.github.projektalmanac.comunidades.generated.dto.UsuarioCreadoDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring")
interface UserMapper {
    companion object {
        val INSTANCE = Mappers.getMapper(UserMapper::class.java)
    }

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "apellidos", target = "lastName")
    fun toEntity(dto: CreacionUsuarioDto): User

    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "lastName", target = "apellidos")
    @Mapping(source = "idUser", target = "id")
    fun toDto(entity: User): UsuarioCreadoDto
}
