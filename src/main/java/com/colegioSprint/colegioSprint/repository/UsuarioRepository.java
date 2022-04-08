package com.colegioSprint.colegioSprint.repository;

import com.colegioSprint.colegioSprint.dto.UsersInterface;
import com.colegioSprint.colegioSprint.dto.UsersJoin;
import com.colegioSprint.colegioSprint.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
  @Query(value = "select u.usuario, u.password, r.nombre_rol as rol from usuario u inner join rol r", nativeQuery = true)
   List<UsersInterface> getUsers();
  @Query(nativeQuery = true)
   List<UsersJoin> getUsersClass();
  @Query(nativeQuery = true)
  UsersJoin getUsersClassById(@Param("id_persona") int id);
  boolean existsByidPersona(int id);
  Optional<Usuario> findByusuario(String usuario);
  List<Usuario> findAllByOrderByIdPersonaDesc();
  int deleteByidPersona(int id);
  Usuario findByidPersona(int id);
  boolean existsByUsuario(String usuario);
}
