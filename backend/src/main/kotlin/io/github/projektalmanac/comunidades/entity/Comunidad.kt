package io.github.projektalmanac.comunidades.entity

import jakarta.persistence.*

@Entity
class Comunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var nombre: String? = null
    var descripcion: String? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    var dueno: User? = null

    var visibilidad: String? = null
    var categoria: String? = null
    var descripcionCorta: String? = null
    
    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "Usuarios",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "comunidad_id")]
    )

    var usuariosInscritos: MutableList<User> = ArrayList()
}
