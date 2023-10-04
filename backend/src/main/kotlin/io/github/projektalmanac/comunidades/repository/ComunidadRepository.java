package io.github.projektalmanac.comunidades.repository;

import io.github.projektalmanac.comunidades.entity.Comunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunidadRepository extends JpaRepository<Comunidad,Integer> {

    Comunidad findComunidadById(Integer id);
}
