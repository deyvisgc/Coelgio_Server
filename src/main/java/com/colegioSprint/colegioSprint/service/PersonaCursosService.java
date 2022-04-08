package com.colegioSprint.colegioSprint.service;

import com.colegioSprint.colegioSprint.entity.Persona;
import com.colegioSprint.colegioSprint.entity.PersonaCursos;
import com.colegioSprint.colegioSprint.repository.PersonaCursosRepository;
import com.colegioSprint.colegioSprint.repository.PersonaRepository;
import com.colegioSprint.colegioSprint.serviceRepository.PersonaCursosServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonaCursosService implements PersonaCursosServiceRepository {
  @Autowired
  PersonaRepository personaRepository;
  @Autowired
  PersonaCursosRepository cursosRepository;

  @Override
  public void save(List<PersonaCursos> personaCursos) {
    cursosRepository.saveAll(personaCursos);
  }

  @Override
  public List<PersonaCursos> findByidCursoAndByidPersona(int idCurso, int idPersona) {
    return cursosRepository.findByIdCursoAndIdPersona(idCurso, idPersona);
  }

  @Override
  public List<Persona> getPerson() {
    return (List<Persona>) personaRepository.findAll();
  }

  @Override
  public Optional<Persona> getPersonById(int id) {
    return personaRepository.findById(id);
  }

  @Override
  public List<PersonaCursos> findByIdCurso(int id) {
    return cursosRepository.findByIdCurso(id);
  }
}
