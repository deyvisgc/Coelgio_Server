package com.colegioSprint.colegioSprint.repository;

import com.colegioSprint.colegioSprint.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface NotasRepository extends JpaRepository<Nota, Integer>  {

  Optional<Nota> findByidCurso(int idCurso);
  Optional<List<Nota>> findByidPersona(int idPersona);
  List<Nota> findByIdCursoAndIdPersona(int idCurso, int idPersona);
  //List<NotasJoin> getAllNotas();
  //List<NotasJoin> getllById(int id);
}
