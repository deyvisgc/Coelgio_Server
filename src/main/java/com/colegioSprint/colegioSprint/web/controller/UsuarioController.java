package com.colegioSprint.colegioSprint.web.controller;

import com.colegioSprint.colegioSprint.Validate.ValidateErros;
import com.colegioSprint.colegioSprint.dto.UsersJoin;
import com.colegioSprint.colegioSprint.entity.Persona;
import com.colegioSprint.colegioSprint.entity.Usuario;
import com.colegioSprint.colegioSprint.mensaje.Mensaje;
import com.colegioSprint.colegioSprint.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController extends ValidateErros{

  @Autowired
  UsuarioService usuarioService;

  @GetMapping("/")
  public ResponseEntity<List<UsersJoin>> getAll() {
    try {
      return new ResponseEntity(usuarioService.getUsersClass(), HttpStatus.OK);
    }catch (Exception exception) {
      return  new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  @GetMapping("/orderDesc")
  public ResponseEntity<List<Usuario>> getAllOrderDesc() {
    try {
      return new ResponseEntity(usuarioService.findAllByOrderByIdPersonaDesc(), HttpStatus.OK);
    }catch (Exception exception) {
      return  new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  @GetMapping("/details/{id}")
  public ResponseEntity<UsersJoin> getByID(@PathVariable(value = "id") int id) {
    try {
      if (!usuarioService.existsByidPersona(id)) {
        return new ResponseEntity(new Mensaje("no existe informacion para el id " + id), HttpStatus.NOT_FOUND);
      } else {
        return new ResponseEntity(usuarioService.getUsersClassById(id), HttpStatus.OK);
      }
    }catch (Exception exception) {
      return  new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  @GetMapping("/search-users/{usuario}")
  public ResponseEntity<Usuario> findByusuario(@PathVariable(value = "usuario") String usuario){
    try {
      if (!usuarioService.findByusuario(usuario).isEmpty()) {
        return new ResponseEntity(usuarioService.findByusuario(usuario), HttpStatus.OK);
      }  else {
        return new ResponseEntity(new Mensaje("no existe informacion"), HttpStatus.NOT_FOUND);
      }
    }catch (Exception exception) {
      return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  @PostMapping("/save")
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ResponseEntity<?> save(@Valid @RequestBody UsersJoin persona) {
    try {
      if (persona.getPassword().isEmpty()) {
        return new ResponseEntity(new Mensaje("Password es requerido."), HttpStatus.OK);
      }
      persona.setFecha(LocalDateTime.now());
      Persona per = new Persona(persona.getNombre(), persona.getApellidos(), "", persona.getCodigoInterno(), persona.getEmail(), persona.getIdGrado(), persona.getFecha());
      Persona pers = usuarioService.savePersona(per);
      Usuario usuario = new Usuario(persona.getUsuario(), persona.getPassword(), persona.getIdRol(), pers.getIdPersona());
      usuarioService.saveUsuario(usuario);
      return new ResponseEntity(new Mensaje("Usuario registrado."), HttpStatus.OK);
    }catch (Exception exception) {
      return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("/delete/{id}")
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
    try{
      if (!usuarioService.existsByidPersona(id)) {
        return new ResponseEntity(new Mensaje("no existe informacion para el id " + id), HttpStatus.NOT_FOUND);
      } else {
        usuarioService.deleteUsers(id);
        usuarioService.deletePerson(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
      }
    }catch (Exception exception){
      return  new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  @PutMapping("/update")
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ResponseEntity<?> update(@Valid @RequestBody UsersJoin usersJoin) {
    try{

      if (!usuarioService.existsByidPersona(usersJoin.getId_persona())) {
        return new ResponseEntity(new Mensaje("no existe informacion para " + usersJoin.getNombre()), HttpStatus.NOT_FOUND);
      }
      if (usuarioService.existsByUsuario(usersJoin.getUsuario()) && usuarioService.findByusuario(usersJoin.getUsuario()).get().getIdPersona() != usersJoin.getId_persona()) {
        return new ResponseEntity(new Mensaje("El usuario " + usersJoin.getUsuario() + " ya existe"), HttpStatus.BAD_REQUEST);
      }
      Usuario users =  usuarioService.findByidPersonaUsuario(usersJoin.getId_persona());
      users.setUsuario(usersJoin.getUsuario());
      users.setIdRol(usersJoin.getIdRol());
      usuarioService.saveUsuario(users);
      Persona persona = usuarioService.findByidPersona(usersJoin.getId_persona());
      persona.setNombre(usersJoin.getNombre());
      persona.setApellidos(usersJoin.getApellidos());
      persona.setCodigoInterno(usersJoin.getCodigoInterno());
      persona.setEmail(usersJoin.getEmail());
      persona.setIdGrado(usersJoin.getIdGrado());
      usuarioService.savePersona(persona);
      return new ResponseEntity(new Mensaje("Usuario Actualizado"), HttpStatus.OK);

    }catch (Exception exception) {
      return  new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
