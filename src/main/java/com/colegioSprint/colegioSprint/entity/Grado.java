package com.colegioSprint.colegioSprint.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "grado")
public class Grado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id_grado;
  @NotBlank(message = "Descripción es requerida")
  private String descripcion;
  @NotBlank(message = "Sección es requerida")
  private String seccion;

  @OneToMany(mappedBy = "grado", cascade=CascadeType.ALL)
  List<Persona> personas;

  public List<Persona> getPersonas() {
    return personas;
  }

  public void setPersonas(List<Persona> personas) {
    this.personas = personas;
  }

  public Integer getId_grado() {
    return id_grado;
  }

  public void setId_grado(Integer id_grado) {
    this.id_grado = id_grado;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getSeccion() {
    return seccion;
  }

  public void setSeccion(String seccion) {
    this.seccion = seccion;
  }
}
