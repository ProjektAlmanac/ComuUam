package io.github.projektalmanac.comunidades.entity

import jakarta.persistence.*

@Entity
class Comunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null
    val nombre: String? = null
    val descripcion: String? = null

    @ManyToOne
    val dueno: User? = null

    val visibilidad: String? = null
    val categoria: String? = null

    @ManyToMany
    @JoinTable(
        name = "Usuarios",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "comunidad_id")]
    )
    val usuariosInscritos: List<User> = ArrayList()
}
