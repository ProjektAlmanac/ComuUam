package io.github.projektalmanac.comunidades.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Comunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripccion;
    private String categoria;
    private String tipo;
    @ManyToMany
    @JoinTable(
            name = "Usuarios",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "comunidad_id")
    )
    private List<User> users = new ArrayList<>();

}
