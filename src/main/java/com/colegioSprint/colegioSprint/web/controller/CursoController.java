package com.colegioSprint.colegioSprint.web.controller;

import com.colegioSprint.colegioSprint.Validate.ValidateErros;
import com.colegioSprint.colegioSprint.entity.Curso;
import com.colegioSprint.colegioSprint.service.CursoService;
import com.colegioSprint.colegioSprint.mensaje.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
@CrossOrigin(origins = "http://localhost:4200")
public class CursoController extends ValidateErros {
  @Autowired
  private CursoService cursoService;

  @GetMapping("/")
  ResponseEntity<List<Curso>> getAll() {
    return new ResponseEntity(cursoService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/details/{id}")
  ResponseEntity<Optional<Curso>> getById(@PathVariable("id") Integer  id) {
    return cursoService.getById(id)
            .map(c -> new ResponseEntity(c, HttpStatus.OK))
            .orElse(new ResponseEntity(new Mensaje("No existe informacion"), HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/delete/{id}")
  ResponseEntity<?> delete(@PathVariable("id") int id) {
    return cursoService.getById(id).map(c -> {
      try {
        cursoService.delete(id);
        return new ResponseEntity(new Mensaje("Curso Eliminado"), HttpStatus.OK);
      }catch (Exception exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
      }
    }).orElse(new ResponseEntity(new Mensaje("no existe el id a eliminar"), HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  ResponseEntity<?> save(@Valid @RequestBody Curso curso) {
     if (cursoService.existsByNombre(curso.getNombreCurso())) {
       return new ResponseEntity(new Mensaje("ya existe un registro con ese nombre"), HttpStatus.BAD_REQUEST);
     }
     cursoService.save(curso);
     return new ResponseEntity(new Mensaje("Curso Creado"), HttpStatus.CREATED);
  }
  @PutMapping("/update")
  ResponseEntity<?> update(@Valid @RequestBody Curso curso) {

    try{

      if (cursoService.getById(curso.getIdCurso()).isEmpty()) {
        return new ResponseEntity(new Mensaje("El id " + curso.getIdCurso() + " no existe"), HttpStatus.NOT_FOUND);
      }
      if (cursoService.existsByNombre(curso.getNombreCurso()) && cursoService.getByNombreCurso(curso.getNombreCurso()).get().getIdCurso() != curso.getIdCurso()) {
        return new ResponseEntity(new Mensaje("EL curso " + curso.getNombreCurso() + " ya existe"), HttpStatus.OK);
      }

      Curso c = cursoService.getById(curso.getIdCurso()).get();
      c.setNombreCurso(curso.getNombreCurso());
      cursoService.save(c);
      return new ResponseEntity(new Mensaje("Curso actualizado"), HttpStatus.OK);
    }catch (Exception exception) {
      return new ResponseEntity(new Mensaje(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }

}
