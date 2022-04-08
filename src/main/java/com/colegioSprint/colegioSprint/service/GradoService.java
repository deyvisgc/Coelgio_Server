package com.colegioSprint.colegioSprint.service;

import com.colegioSprint.colegioSprint.entity.Grado;
import com.colegioSprint.colegioSprint.repository.GradoRespository;
import com.colegioSprint.colegioSprint.serviceRepository.GradoServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradoService implements GradoServiceRepository {
  @Autowired
  GradoRespository gradoRespository;
  @Override
  public Grado save(Grado grado) {
    return gradoRespository.save(grado);
  }

  @Override
  public void delete(int id) {
    gradoRespository.deleteById(id);
  }

  @Override
  public List<Grado> getAll() {
    return (List<Grado>) gradoRespository.findAll();
  }

  @Override
  public Optional<Grado> getById(int id) {
    return gradoRespository.findById(id);
  }

  @Override
  public boolean existsByDescripcionAndSeccion(String descripcion, String secsion) {
    return gradoRespository.existsByDescripcionAndSeccion(descripcion, secsion);
  }

  @Override
  public Optional<Grado> getByDescripcionAndSeccion(String descripcion, String session) {
    return gradoRespository.getByDescripcionAndSeccion(descripcion, session);
  }
}
