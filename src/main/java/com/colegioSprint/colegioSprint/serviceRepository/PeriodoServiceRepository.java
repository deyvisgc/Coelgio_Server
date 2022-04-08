package com.colegioSprint.colegioSprint.serviceRepository;

import com.colegioSprint.colegioSprint.entity.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PeriodoServiceRepository{
  void save(Periodo periodo);
  List<Periodo> getAll();
  Optional<Periodo> getById(int id);
  List<Periodo> findByYear(int year);
}
