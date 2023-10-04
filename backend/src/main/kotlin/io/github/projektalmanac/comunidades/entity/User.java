package io.github.projektalmanac.comunidades.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String name;
    private String lastName;

    @ManyToMany(mappedBy = "User")
    private List<Comunidad> comunidad = new ArrayList<>();
}
