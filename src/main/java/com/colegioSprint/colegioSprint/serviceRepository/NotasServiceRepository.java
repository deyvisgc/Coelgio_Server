package com.colegioSprint.colegioSprint.serviceRepository;

import com.colegioSprint.colegioSprint.dto.NotasJoin;
import com.colegioSprint.colegioSprint.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface NotasServiceRepository {
   Nota save(Nota nota);
   void delete(int id);
   List<Nota> getAll();
   Optional<Nota> findByidCurso(int idCurso);
   Optional<List<Nota>> findByidPersona(int idPersona);
   List<Nota> findByIdCursoAndIdPersona(int idCurso, int idPersona);
}
