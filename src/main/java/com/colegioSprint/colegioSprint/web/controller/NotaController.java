package com.colegioSprint.colegioSprint.web.controller;

import com.colegioSprint.colegioSprint.Validate.ValidateErros;
import com.colegioSprint.colegioSprint.entity.*;
import com.colegioSprint.colegioSprint.mensaje.Mensaje;
import com.colegioSprint.colegioSprint.service.CursoService;
import com.colegioSprint.colegioSprint.service.NotasService;
import com.colegioSprint.colegioSprint.service.PeriodoService;
import com.colegioSprint.colegioSprint.service.PersonaCursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notas")
public class NotaController extends ValidateErros {
  @Autowired
  NotasService notasService;
  @Autowired
  PeriodoService periodoService;
  @Autowired
  PersonaCursosService personaCursosService;
  @Autowired
  CursoService cursoService;
  @GetMapping("/")
  public ResponseEntity<List<Nota>> getAll() {
    return new ResponseEntity(notasService.getAll(), HttpStatus.OK);
  }
  @GetMapping("/details-id-curo/{id}")
  public ResponseEntity<Nota> getByIdCurso(@PathVariable(value = "id") int id) {
    if (notasService.findByidCurso(id).isEmpty()) {
      return new ResponseEntity(new Mensaje("No existe informacion"), HttpStatus.OK);
    } else {
      return new ResponseEntity(notasService.findByidCurso(id), HttpStatus.OK);
    }
  }
  @GetMapping("/details-id-persona/{id}")
  public ResponseEntity<List<Nota>> getByIdPersona(@PathVariable(value = "id") int id) {
    if (notasService.findByidPersona(id).isEmpty()) {
      return new ResponseEntity(new Mensaje("No existe informacion"), HttpStatus.OK);
    } else {
      return new ResponseEntity(notasService.findByidPersona(id), HttpStatus.OK);
    }
  }
  @PostMapping("/save")
  public ResponseEntity<?> save(@Valid @RequestBody Nota nota){
    try{
      if (personaCursosService.getPersonById(nota.getIdPersona()).isEmpty()) {
        return new ResponseEntity(new Mensaje("Id persona: " + nota.getIdPersona() + " no existe"), HttpStatus.BAD_REQUEST);
      }
      if (cursoService.getById(nota.getIdCurso()).isEmpty()) {
        return new ResponseEntity(new Mensaje("Id curso : " + nota.getIdCurso() + " no existe"), HttpStatus.BAD_REQUEST);
      }
      if (!notasService.findByIdCursoAndIdPersona(nota.getIdCurso(), nota.getIdPersona()).isEmpty()) {
        return new ResponseEntity(new Mensaje("Existe notas registradas con este estudiante y curso, solo es permitido actualizar las notas"), HttpStatus.BAD_REQUEST);
      }
      BigDecimal  promedio = nota.getPrimeraNota().add(nota.getSegundaNota()).
                             add(nota.getTercerNota()).add(nota.getCuartaNota())
                             .divide(new BigDecimal(4));
      nota.setPromedio(promedio);
      Nota lastNota = notasService.save(nota);
      Periodo periodo = new Periodo();
      periodo.setPromedioTrimestral(promedio);
      periodo.setYear(LocalDateTime.now().getYear());
      periodo.setIdNota(lastNota.getIdNota());
      periodoService.save(periodo);
      return new ResponseEntity(new Mensaje("Notas creadas"), HttpStatus.OK);
    }catch (Exception exception) {
      return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
