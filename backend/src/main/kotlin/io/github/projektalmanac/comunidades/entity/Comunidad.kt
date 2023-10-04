package io.github.projektalmanac.comunidades.entity

import jakarta.persistence.*

@Entity
class Comunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int? = null
    private val nombre: String? = null
    private val descripccion: String? = null
    private val categoria: String? = null
    private val tipo: String? = null

    @ManyToMany
    @JoinTable(
        name = "Usuarios",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "comunidad_id")]
    )
    private val users: List<User> = ArrayList()
}
