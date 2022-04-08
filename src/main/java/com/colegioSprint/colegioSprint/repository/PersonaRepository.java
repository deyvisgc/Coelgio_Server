package com.colegioSprint.colegioSprint.repository;

import com.colegioSprint.colegioSprint.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
  Persona findByidPersona(int id);
}
