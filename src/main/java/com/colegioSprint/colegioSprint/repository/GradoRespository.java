package com.colegioSprint.colegioSprint.repository;

import com.colegioSprint.colegioSprint.entity.Grado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface GradoRespository extends CrudRepository<Grado, Integer> {
  boolean existsByDescripcionAndSeccion(String descripcion, String seccion);
  Optional<Grado> getByDescripcionAndSeccion(String descripcion, String seccion);
}
