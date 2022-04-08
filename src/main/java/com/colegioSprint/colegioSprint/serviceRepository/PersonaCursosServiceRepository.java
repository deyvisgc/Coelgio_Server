package com.colegioSprint.colegioSprint.serviceRepository;

import com.colegioSprint.colegioSprint.entity.Persona;
import com.colegioSprint.colegioSprint.entity.PersonaCursos;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PersonaCursosServiceRepository {
  void save(List<PersonaCursos> personaCursos);
  List<PersonaCursos> findByidCursoAndByidPersona(int idCurso, int idPersona);
  List<Persona> getPerson();
  Optional<Persona> getPersonById(int id);
  List<PersonaCursos> findByIdCurso(int id);
}
