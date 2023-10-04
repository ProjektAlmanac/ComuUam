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


    @ManyToMany(mappedBy = "usuarios")
    val comunidad: MutableList<Comunidad> = ArrayList()


    @OneToMany
    val dueno: MutableList<Comunidad> = ArrayList()

    fun agregarComunidad(comunidad2: Comunidad): Boolean {
        return if (comunidad.add(comunidad2) && dueno.add(comunidad2)) {
            true
        } else {
            false
        }
    }
}
