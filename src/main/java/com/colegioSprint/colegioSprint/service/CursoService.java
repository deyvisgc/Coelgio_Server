package com.colegioSprint.colegioSprint.service;

import com.colegioSprint.colegioSprint.entity.Curso;
import com.colegioSprint.colegioSprint.repository.CursoRepository;
import com.colegioSprint.colegioSprint.serviceRepository.CursoServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CursoService implements CursoServiceRepository {
  @Autowired
  CursoRepository cursoRepository;

  @Override
  public Curso save(Curso curso) {
    return cursoRepository.save(curso);
  }
  @Override
  public void delete(int id) {
     cursoRepository.deleteById(id);
  }

  @Override
  public List<Curso> getAll() {
    return (List<Curso>) cursoRepository.findAll();
  }

  @Override
  public Optional<Curso> getById(int id) {
    return cursoRepository.findById(id);
  }

  @Override
  public boolean existsByNombre(String nombre) {
    return cursoRepository.existsByNombreCurso(nombre);
  }

  @Override
  public Optional<Curso> getByNombreCurso(String nombre) {
    return cursoRepository.getByNombreCurso(nombre);
  }

  @Override
  public List<Curso> findByidCurso(int id) {
    return cursoRepository.findByidCurso(id);
  }
}
