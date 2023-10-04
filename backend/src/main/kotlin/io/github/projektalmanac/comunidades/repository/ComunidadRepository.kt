package io.github.projektalmanac.comunidades.repository

import io.github.projektalmanac.comunidades.entity.Comunidad
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComunidadRepository : JpaRepository<Comunidad?, Int?> {
    fun findComunidadById(id: Int?): Comunidad?
    fun updateByComunidad(comunidad: Comunidad?): Comunidad?
}
