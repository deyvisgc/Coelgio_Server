package com.colegioSprint.colegioSprint.service;

import com.colegioSprint.colegioSprint.entity.Periodo;
import com.colegioSprint.colegioSprint.repository.PeriodoRepository;
import com.colegioSprint.colegioSprint.serviceRepository.PeriodoServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PeriodoService implements PeriodoServiceRepository {
  @Autowired
  PeriodoRepository periodoRepository;
  @Override
  public void save(Periodo periodo) {
    periodoRepository.save(periodo);
  }

  @Override
  public List<Periodo> getAll() {
    return periodoRepository.findAll();
  }

  @Override
  public Optional<Periodo> getById(int id) {
    return periodoRepository.findById(id);
  }

  @Override
  public List<Periodo> findByYear(int year) {
    return periodoRepository.findByYear(year);
  }
}
