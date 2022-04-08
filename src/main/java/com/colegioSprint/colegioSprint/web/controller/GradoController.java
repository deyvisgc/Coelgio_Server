package com.colegioSprint.colegioSprint.web.controller;

import com.colegioSprint.colegioSprint.Validate.ValidateErros;
import com.colegioSprint.colegioSprint.entity.Grado;
import com.colegioSprint.colegioSprint.mensaje.Mensaje;
import com.colegioSprint.colegioSprint.service.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/grado")
// @CrossOrigin(origins = "http://localhost:4200")
public class GradoController extends ValidateErros {
  @Autowired
  GradoService gradoService;
  @GetMapping("/")
  public ResponseEntity<Grado> getAll() {
    return  new ResponseEntity(gradoService.getAll(), HttpStatus.OK);
  }
  @PostMapping("/save")
  public ResponseEntity<?> save (@Valid @RequestBody Grado grado) {
    try {
      if (gradoService.existsByDescripcionAndSeccion(grado.getDescripcion(), grado.getSeccion())) {
        return new ResponseEntity(new Mensaje("ya existe un grado y seccion con esa informacion"), HttpStatus.BAD_REQUEST);
      }
      gradoService.save(grado);
      return new ResponseEntity(new Mensaje("Grado registrado"), HttpStatus.OK);
    }catch (Exception exception) {
      return new ResponseEntity(new Mensaje(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }
  @GetMapping("/details/{id}")
  public ResponseEntity<Optional<Grado>> getByID (@PathVariable("id") int id) {
    try{
      Optional<Grado> grado = gradoService.getById(id);
      if (grado.isEmpty()) {
        return new ResponseEntity(new Mensaje("No existe informacion"), HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity(grado, HttpStatus.OK);
    }catch (Exception exception) {
      return new ResponseEntity(new Mensaje(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }
  @DeleteMapping("/delete/{id}")

  public ResponseEntity<?> delete(@PathVariable("id") int id) {
    try {
      if (gradoService.getById(id).isEmpty()) {
        return new ResponseEntity(new Mensaje("No existe informacion para este id"), HttpStatus.BAD_REQUEST);
      }
      gradoService.delete(id);
      return new ResponseEntity(new Mensaje("Grado Eliminado"), HttpStatus.OK);

    }catch (Exception exception) {
      return new ResponseEntity(new Mensaje(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/update")
  public ResponseEntity<?> update(@Valid @RequestBody Grado grado) {
    try{
      if (gradoService.getById(grado.getId_grado()).isEmpty()) {
        return new ResponseEntity(new Mensaje("No existe informacion para este id"), HttpStatus.BAD_REQUEST);
      }

      boolean exist = gradoService.existsByDescripcionAndSeccion(grado.getDescripcion(), grado.getSeccion());
      Optional<Grado> lgrado = gradoService.getByDescripcionAndSeccion(grado.getDescripcion(), grado.getSeccion());

      if (exist && lgrado.get().getId_grado() != grado.getId_grado()) { // valido para evitar actualizar grado y seccion existentes
        return new ResponseEntity(new Mensaje("La descripcion y la seccion ya existen"), HttpStatus.BAD_REQUEST);
      }
      Grado g = gradoService.getById(grado.getId_grado()).get();
      g.setDescripcion(grado.getDescripcion());
      g.setSeccion(grado.getSeccion());
      gradoService.save(g);
      return new ResponseEntity(new Mensaje("Grado actualziado"), HttpStatus.OK);
    }catch (Exception exception) {
      return new ResponseEntity(new Mensaje(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }


}
