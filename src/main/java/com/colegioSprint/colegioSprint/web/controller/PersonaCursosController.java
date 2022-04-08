package com.colegioSprint.colegioSprint.web.controller;

import com.colegioSprint.colegioSprint.entity.Persona;
import com.colegioSprint.colegioSprint.entity.PersonaCursos;
import com.colegioSprint.colegioSprint.mensaje.Mensaje;
import com.colegioSprint.colegioSprint.service.CursoService;
import com.colegioSprint.colegioSprint.service.PersonaCursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("person-cours")
public class PersonaCursosController {
  @Autowired
  PersonaCursosService personaCursosService;
  @Autowired
  CursoService cursoService;
  @GetMapping("/")
  public ResponseEntity<List<Persona>> getPerson() {
    try {
      return new ResponseEntity(personaCursosService.getPerson(), HttpStatus.OK);
    }catch (Exception exception) {
      return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  @GetMapping("/details/{id}")
  public ResponseEntity<Optional<Persona>> getById(@PathVariable(value = "id") int id) {
    try {
      if (personaCursosService.getPersonById(id).isEmpty()) {
        return new ResponseEntity(new Mensaje("No existe informacion"), HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity(personaCursosService.getPersonById(id), HttpStatus.OK);
    }catch (Exception exception) {
      return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  @PostMapping("/save")
  public ResponseEntity<?> save(@Valid @RequestBody List<PersonaCursos> personaCursos) {
    try {
      List<Mensaje> list = new ArrayList<>();
      for (PersonaCursos cursos: personaCursos) {
        if (personaCursosService.getPersonById(cursos.getIdPersona()).isEmpty()) {
          Mensaje mensaje = new Mensaje("Id persona no existe: " + cursos.getIdPersona());
          list.add(mensaje);
        }
        if (cursoService.getById(cursos.getIdCurso()).isEmpty()) {
          Mensaje mensaje = new Mensaje("Id curso no existe: " + cursos.getIdCurso());
          list.add(mensaje);
        }
        if (!personaCursosService.findByidCursoAndByidPersona(cursos.getIdCurso(), cursos.getIdPersona()).isEmpty()) {
          Mensaje mensaje = new Mensaje("Ya existe informacion con el idCurso: " + cursos.getIdCurso() + " y el idPersona: " + cursos.getIdPersona());
          list.add(mensaje);
        }
      }
      if (!list.isEmpty()){
        return new ResponseEntity(list, HttpStatus.BAD_REQUEST);
      } else {
        personaCursosService.save(personaCursos);
        return new ResponseEntity(new Mensaje("Cursos registrados"), HttpStatus.OK);
      }
    }catch (Exception exception) {
      return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
