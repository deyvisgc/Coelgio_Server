package com.colegioSprint.colegioSprint.repository;

import com.colegioSprint.colegioSprint.entity.PersonaCursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonaCursosRepository extends JpaRepository<PersonaCursos, Integer> {
  List<PersonaCursos> findByIdCursoAndIdPersona(int idCurso, int idPersona);
  List<PersonaCursos> findByIdCurso(int id);
}
