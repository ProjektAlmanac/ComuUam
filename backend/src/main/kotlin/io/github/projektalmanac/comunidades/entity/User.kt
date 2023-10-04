package io.github.projektalmanac.comunidades.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idUser: Int? = null
    var name: String? = null
    var lastName: String? = null
    var correo: String? = null

    @ManyToMany(mappedBy = "usuariosInscritos")
    var comunidad: List<Comunidad> = ArrayList()

    @OneToMany
    var dueno: List<Comunidad> = ArrayList()
}
