package io.github.projektalmanac.comunidades.entity

import jakarta.persistence.*

@Entity
class Comunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null
    val nombre: String? = null
    val descripccion: String? = null
    val categoria: String? = null
    val tipo: String? = null

    @ManyToMany
    @JoinTable(
        name = "Usuarios",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "comunidad_id")]
    )
    val users: List<User> = ArrayList()
}
