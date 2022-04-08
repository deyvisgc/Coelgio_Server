package com.colegioSprint.colegioSprint.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_rol")
  private Integer idRol;
  private String nombre_rol;
  @OneToMany(targetEntity = Usuario.class, mappedBy = "rol", orphanRemoval = false, fetch = FetchType.LAZY)
  List<Usuario> usuarios;

  public Integer getIdRol() {
    return idRol;
  }

  public void setIdRol(Integer idRol) {
    this.idRol = idRol;
  }

  public String getNombre_rol() {
    return nombre_rol;
  }

  public void setNombre_rol(String nombre_rol) {
    this.nombre_rol = nombre_rol;
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }
}
