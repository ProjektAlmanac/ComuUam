package io.github.projektalmanac.comunidades.mapper

import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface UserMapper {
    companion object {
        val INSTANCE = Mappers.getMapper(UserMapper::class.java)
    }
}
