package com.colegioSprint.colegioSprint.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "persona_curso")
public class PersonaCursos {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_persona_curso")
  private Integer idPersonaCurso;
  @Column(name = "id_curso")
  @NotNull(message = "Curso requerido")
  private Integer idCurso;
  @Column(name = "id_persona")
  @NotNull(message = "Estudiante requerido")
  private Integer idPersona;
  @Column(name = "is_aprobado")
  private Integer isAprobo;
  private BigDecimal promedio_final;

  public BigDecimal getPromedio_final() {
    return promedio_final;
  }

  public void setPromedio_final(BigDecimal promedio_final) {
    this.promedio_final = promedio_final;
  }

  public Integer getIsAprobo() {
    return isAprobo;
  }

  public void setIsAprobo(Integer isAprobo) {
    this.isAprobo = isAprobo;
  }

  @JsonIgnore
  @ManyToOne()
  @JoinColumn(name = "id_persona", insertable = false, updatable = false)
  private Persona person;
  @JsonIgnore
  @ManyToOne()
  @JoinColumn(name = "id_curso", insertable = false, updatable = false)
  private Curso personCurso;

  public Curso getPersonCurso() {
    return personCurso;
  }

  public void setPersonCurso(Curso personCurso) {
    this.personCurso = personCurso;
  }

  public PersonaCursos() {
  }

  public PersonaCursos(Integer idPersona, Persona person) {
    this.idPersona = idPersona;
    this.person = person;
  }

  public Persona getPerson() {
    return person;
  }

  public void setPerson(Persona person) {
    this.person = person;
  }

  public Integer getIdPersonaCurso() {
    return idPersonaCurso;
  }

  public void setIdPersonaCurso(Integer idPersonaCurso) {
    this.idPersonaCurso = idPersonaCurso;
  }

  public Integer getIdCurso() {
    return idCurso;
  }

  public void setIdCurso(Integer idCurso) {
    this.idCurso = idCurso;
  }

  public Integer getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(Integer idPersona) {
    this.idPersona = idPersona;
  }
}
