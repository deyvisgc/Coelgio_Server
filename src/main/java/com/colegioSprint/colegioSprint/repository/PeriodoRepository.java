package com.colegioSprint.colegioSprint.repository;
import com.colegioSprint.colegioSprint.entity.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {
  List<Periodo> findByYear(int year);
}
