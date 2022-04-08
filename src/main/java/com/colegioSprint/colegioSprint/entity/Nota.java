package com.colegioSprint.colegioSprint.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "notas")
public class Nota {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_nota")
  private Integer idNota;
  @Column(name = "nota_1")
  private BigDecimal primeraNota;
  @Column(name = "nota_2")
  private BigDecimal segundaNota;
  @Column(name = "nota_3")
  private BigDecimal tercerNota;
  @Column(name = "nota_4")
  private BigDecimal cuartaNota;
  private BigDecimal promedio;
  @NotNull(message = "Persona es requerida")
  @Column(name = "id_persona")
  private Integer idPersona;
  @NotNull(message = "Curso es requerido")
  @Column(name = "id_curso")
  private Integer idCurso;

  @ManyToOne
  @JoinColumn(name = "id_persona", insertable = false, updatable = false)
  private Persona personaNotas;

  @ManyToOne
  @JoinColumn(name = "id_curso", insertable = false, updatable = false)
  private Curso notaCurso;
  @JsonIgnore
  @OneToMany(mappedBy = "notaPeriodo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  List<Periodo> periodo;

  public Curso getNotaCurso() {
    return notaCurso;
  }

  public void setNotaCurso(Curso notaCurso) {
    this.notaCurso = notaCurso;
  }

  public List<Periodo> getPeriodo() {
    return periodo;
  }

  public void setPeriodo(List<Periodo> periodo) {
    this.periodo = periodo;
  }
  public BigDecimal getPrimeraNota() {
    return primeraNota;
  }

  public void setPrimeraNota(BigDecimal primeraNota) {
    this.primeraNota = primeraNota;
  }

  public BigDecimal getSegundaNota() {
    return segundaNota;
  }

  public void setSegundaNota(BigDecimal segundaNota) {
    this.segundaNota = segundaNota;
  }

  public BigDecimal getTercerNota() {
    return tercerNota;
  }

  public void setTercerNota(BigDecimal tercerNota) {
    this.tercerNota = tercerNota;
  }

  public BigDecimal getCuartaNota() {
    return cuartaNota;
  }

  public void setCuartaNota(BigDecimal cuartaNota) {
    this.cuartaNota = cuartaNota;
  }

  public Persona getPersonaNotas() {
    return personaNotas;
  }

  public void setPersonaNotas(Persona personaNotas) {
    this.personaNotas = personaNotas;
  }

  public Integer getIdNota() {
    return idNota;
  }

  public void setIdNota(Integer idNota) {
    this.idNota = idNota;
  }

  public BigDecimal getPromedio() {
    return promedio;
  }

  public void setPromedio(BigDecimal promedio) {
    this.promedio = promedio;
  }

  public Integer getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(Integer idPersona) {
    this.idPersona = idPersona;
  }

  public Integer getIdCurso() {
    return idCurso;
  }

  public void setIdCurso(Integer idCurso) {
    this.idCurso = idCurso;
  }
}
