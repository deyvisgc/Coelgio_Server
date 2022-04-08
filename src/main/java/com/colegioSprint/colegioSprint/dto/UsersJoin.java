package com.colegioSprint.colegioSprint.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class UsersJoin {
  private Integer id_persona;
  @NotBlank(message = "Usuario requerido")
  private String  usuario;
  //@NotBlank(message = "Pasword requerido")
  private String  password;
  @NotBlank(message = "Nombre requerido")
  private String  nombre;
  @NotBlank(message = "Apellidos requerido")
  private String  apellidos;
  private String  codigoInterno;
  private LocalDateTime  fecha;
  private String  nombre_rol;
  private String  email;
  @Min(value = 1 , message = "El id del grado debe ser mayor a 0")
  private Integer idGrado;
  @Min(value = 1 , message = "El id minimo del rol debe ser mayor a 0")
  private Integer idRol;

  public LocalDateTime getFecha() {
    return fecha;
  }

  public void setFecha(LocalDateTime fecha) {
    this.fecha = fecha;
  }

  public Integer getIdGrado() {
    return idGrado;
  }

  public void setIdGrado(Integer idGrado) {
    this.idGrado = idGrado;
  }

  public Integer getIdRol() {
    return idRol;
  }

  public void setIdRol(Integer idRol) {
    this.idRol = idRol;
  }

  public UsersJoin() {
  }

  public UsersJoin(Integer id_persona, String usuario, String password, String nombre_rol, String nombre, String apellidos, String codigoInterno, String email, LocalDateTime fecha) {
    this.id_persona = id_persona;
    this.usuario = usuario;
    this.password = password;
    this.nombre_rol = nombre_rol;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.codigoInterno = codigoInterno;
    this.email = email;
    this.fecha = fecha;
  }

  public Integer getId_persona() {
    return id_persona;
  }

  public void setId_persona(Integer id_persona) {
    this.id_persona = id_persona;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }
  public String getCodigoInterno() {
    return codigoInterno;
  }

  public void setCodigoInterno(String codigoInterno) {
    this.codigoInterno = codigoInterno;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  public String getNombre_rol() {
    return nombre_rol;
  }

  public void setNombre_rol(String nombre_rol) {
    this.nombre_rol = nombre_rol;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
