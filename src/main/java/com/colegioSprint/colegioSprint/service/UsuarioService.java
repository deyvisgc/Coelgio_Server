package com.colegioSprint.colegioSprint.service;

import com.colegioSprint.colegioSprint.dto.UsersInterface;
import com.colegioSprint.colegioSprint.dto.UsersJoin;
import com.colegioSprint.colegioSprint.entity.Persona;
import com.colegioSprint.colegioSprint.entity.Usuario;
import com.colegioSprint.colegioSprint.repository.PersonaRepository;
import com.colegioSprint.colegioSprint.repository.UsuarioRepository;
import com.colegioSprint.colegioSprint.serviceRepository.UsuarioServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service

public class UsuarioService implements UsuarioServiceRepository {
  @Autowired
  UsuarioRepository usuarioRepository;
  @Autowired
  PersonaRepository personaRepository;
  @Override
  public void saveUsuario(Usuario usuario) {
    usuarioRepository.save(usuario);
  }

  @Override
  public Persona savePersona(Persona persona) {
    return personaRepository.save(persona);
  }

  @Override
  public boolean existsByidPersona(int id) {
    return usuarioRepository.existsByidPersona(id);
  }

  @Override
  public boolean existsByUsuario(String usuario) {
    return usuarioRepository.existsByUsuario(usuario);
  }

  @Override
  public Optional<Usuario> findByusuario(String usuario) {
    return usuarioRepository.findByusuario(usuario);
  }

  @Override
  public List<UsersInterface> getUsers() {
    return usuarioRepository.getUsers();
  }

  @Override
  public List<UsersJoin> getUsersClass() {
    return usuarioRepository.getUsersClass();
  }

  @Override
  public UsersJoin getUsersClassById(int id) {
    return usuarioRepository.getUsersClassById(id);
  }

  @Override
  public List<Usuario> findAllByOrderByIdPersonaDesc() {
    return usuarioRepository.findAllByOrderByIdPersonaDesc();
  }

  @Override
  public void deleteUsers(int id) {
     usuarioRepository.deleteByidPersona(id);
  }
  @Override
  public void deletePerson(int id) {
    personaRepository.deleteById(id);
  }

  @Override
  public Usuario findByidPersonaUsuario(int id) {
    return usuarioRepository.findByidPersona(id);
  }

  @Override
  public Persona findByidPersona(int id) {
    return personaRepository.findByidPersona(id);
  }
}
