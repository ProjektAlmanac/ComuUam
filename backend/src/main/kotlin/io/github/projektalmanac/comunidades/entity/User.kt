package io.github.projektalmanac.comunidades.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val idUser: Int? = null
    private val name: String? = null
    private val lastName: String? = null

    @ManyToMany(mappedBy = "users")
    private val comunidad: List<Comunidad> = ArrayList()
}
