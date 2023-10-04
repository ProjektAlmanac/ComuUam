package io.github.projektalmanac.comunidades.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idUser: Int? = null
    val name: String? = null
    val lastName: String? = null
    val correo: String? = null

    @ManyToMany(mappedBy = "usuariosInscritos")
    val comunidad: List<Comunidad> = ArrayList()

    @OneToMany
    val dueno: List<Comunidad> = ArrayList()
}
