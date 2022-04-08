package com.colegioSprint.colegioSprint.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "notas_periodo")
public class Periodo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_periodo")
  private Integer idPeriodo;
  @Column(name = "promedio_trimestral")
  private BigDecimal promedioTrimestral;
  @NotNull(message = "Año Escolar es requerido")
  private Integer year;
  @Column(name = "id_nota")
  private Integer idNota;

  public Integer getIdNota() {
    return idNota;
  }

  public void setIdNota(Integer idNota) {
    this.idNota = idNota;
  }

  @ManyToOne
  @JoinColumn(name = "id_nota", insertable = false, updatable = false)
  private Nota notaPeriodo;

  public Nota getNotaPeriodo() {
    return notaPeriodo;
  }

  public void setNotaPeriodo(Nota notaPeriodo) {
    this.notaPeriodo = notaPeriodo;
  }

  public Integer getIdPeriodo() {
    return idPeriodo;
  }

  public void setIdPeriodo(Integer idPeriodo) {
    this.idPeriodo = idPeriodo;
  }

  public BigDecimal getPromedioTrimestral() {
    return promedioTrimestral;
  }

  public void setPromedioTrimestral(BigDecimal promedioTrimestral) {
    this.promedioTrimestral = promedioTrimestral;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }
}
