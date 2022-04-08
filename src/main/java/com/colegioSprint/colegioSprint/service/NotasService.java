package com.colegioSprint.colegioSprint.service;

import com.colegioSprint.colegioSprint.dto.NotasJoin;
import com.colegioSprint.colegioSprint.entity.Nota;
import com.colegioSprint.colegioSprint.repository.NotasRepository;
import com.colegioSprint.colegioSprint.serviceRepository.NotasServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NotasService implements NotasServiceRepository {
  @Autowired
  NotasRepository notasRepository;
  @Override
  public Nota save(Nota nota) {
    return notasRepository.save(nota);
  }

  @Override
  public void delete(int id) {
    notasRepository.deleteById(id);
  }

  @Override
  public List<Nota> getAll() {
    return notasRepository.findAll();
  }

  @Override
  public Optional<Nota> findByidCurso(int idCurso) {
    return notasRepository.findByidCurso(idCurso);
  }

  @Override
  public Optional<List<Nota>> findByidPersona(int idPersona) {
    return notasRepository.findByidPersona(idPersona);
  }

  @Override
  public List<Nota> findByIdCursoAndIdPersona(int idCurso, int idPersona) {
    return notasRepository.findByIdCursoAndIdPersona(idCurso, idPersona);
  }

}
