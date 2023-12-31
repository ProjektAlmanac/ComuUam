package io.github.projektalmanac.comunidades.repository

import io.github.projektalmanac.comunidades.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User?, Int?> {

    fun findUserByIdUser(id: Int?): User?
    fun findByCorreo(email: String): User?
}
