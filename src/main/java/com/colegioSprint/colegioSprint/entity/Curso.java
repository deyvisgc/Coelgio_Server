package com.colegioSprint.colegioSprint.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_curso")
  private Integer idCurso;
  @Column(name = "nombre")
  @NotBlank(message = "Nombre curso es requerido")
  private String nombreCurso;
  @JsonIgnore
  @OneToMany(mappedBy = "notaCurso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Nota> notas;
  @JsonIgnore
  @OneToMany(mappedBy = "personCurso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Curso> personCurso;

  public List<Curso> getPersonCurso() {
    return personCurso;
  }

  public void setPersonCurso(List<Curso> personCurso) {
    this.personCurso = personCurso;
  }

  public Integer getIdCurso() {
    return idCurso;
  }

  public void setIdCurso(Integer idCurso) {
    this.idCurso = idCurso;
  }

  public List<Nota> getNotas() {
    return notas;
  }

  public void setNotas(List<Nota> notas) {
    this.notas = notas;
  }

  public String getNombreCurso() {
    return nombreCurso;
  }

  public void setNombreCurso(String nombreCurso) {
    this.nombreCurso = nombreCurso;
  }

}
