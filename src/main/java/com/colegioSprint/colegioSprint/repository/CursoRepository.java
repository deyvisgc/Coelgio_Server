package com.colegioSprint.colegioSprint.repository;

import com.colegioSprint.colegioSprint.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository  extends CrudRepository<Curso, Integer> {
  boolean existsByNombreCurso(String nombre);
  List<Curso> findByidCurso(int id);
  Optional<Curso> getByNombreCurso(String nombre);
}
