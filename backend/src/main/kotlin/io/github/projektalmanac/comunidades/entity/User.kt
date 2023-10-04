package io.github.projektalmanac.comunidades.entity

import jakarta.persistence.*

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val idUser: Int? = null
    private val name: String? = null
    private val lastName: String? = null
    private val correo: String? = null

    @ManyToMany(mappedBy = "User")
    private val comunidad: List<Comunidad> = ArrayList()

    @OneToMany
    private val dueno: List<Comunidad> = ArrayList()
}
