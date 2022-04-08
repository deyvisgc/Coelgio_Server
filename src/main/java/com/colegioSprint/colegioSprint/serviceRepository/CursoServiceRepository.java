package com.colegioSprint.colegioSprint.serviceRepository;

import com.colegioSprint.colegioSprint.entity.Curso;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoServiceRepository {
  Curso save(Curso curso);
  void delete(int id);
  List<Curso> getAll();
  Optional<Curso> getById(int id);
  boolean existsByNombre(String nombre);
  Optional<Curso> getByNombreCurso(String nombre);
  List<Curso> findByidCurso(int id);

}
