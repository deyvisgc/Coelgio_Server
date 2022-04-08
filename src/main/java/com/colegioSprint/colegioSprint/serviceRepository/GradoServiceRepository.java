package com.colegioSprint.colegioSprint.serviceRepository;
import com.colegioSprint.colegioSprint.entity.Grado;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradoServiceRepository {
  Grado save(Grado grado);
  void delete(int id);
  List<Grado> getAll();
  Optional<Grado> getById(int id);
  boolean existsByDescripcionAndSeccion(String descripcion, String seccion);
  Optional<Grado> getByDescripcionAndSeccion(String descripcion, String session);
}
