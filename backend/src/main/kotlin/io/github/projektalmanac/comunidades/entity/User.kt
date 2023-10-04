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
