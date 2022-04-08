package com.colegioSprint.colegioSprint.serviceRepository;

import com.colegioSprint.colegioSprint.dto.UsersInterface;
import com.colegioSprint.colegioSprint.dto.UsersJoin;
import com.colegioSprint.colegioSprint.entity.Persona;
import com.colegioSprint.colegioSprint.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public interface UsuarioServiceRepository {
  void saveUsuario(Usuario usuario);
  Persona savePersona(Persona persona);
  boolean existsByidPersona(int id);
  boolean existsByUsuario(String usuario);
  Optional<Usuario> findByusuario(String usuario);
  List<UsersInterface> getUsers();
  List<UsersJoin> getUsersClass();
  UsersJoin getUsersClassById(int id);
  List<Usuario> findAllByOrderByIdPersonaDesc();
  void deleteUsers(int id);
  void deletePerson(int id);
  Usuario findByidPersonaUsuario(int id);
  Persona findByidPersona(int id);
}
