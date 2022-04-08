package com.colegioSprint.colegioSprint.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "persona")
@SecondaryTable(name = "usuario", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id_usuario"))
public class Persona {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_persona")
  private Integer idPersona;
  private String nombre;
  @NotBlank(message = "Apellidos requeridos")
  private String apellidos;
  private String image;
  @Column(name = "codigo_interno")
  private String codigoInterno;
  private String email;
  @Column(name = "id_grado")
  private Integer idGrado;
  @Column(name = "fecha_creacion")
  private LocalDateTime fecha;
  public Persona(String nombre, String apellidos, String image, String codigoInterno, String email, Integer idGrado, LocalDateTime fecha) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.image = image;
    this.codigoInterno = codigoInterno;
    this.email = email;
    this.idGrado = idGrado;
    this.fecha = fecha;
  }
  public Persona() {
  }

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "id_grado", updatable = false, insertable = false)
  private Grado grado;

  @JsonIgnore
  @OneToMany(mappedBy = "persona", cascade=CascadeType.ALL)
  List<Usuario> persona;
  @JsonIgnore
  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  List<PersonaCursos> personaCursos;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "personaNotas")
  List<Nota> notas;

  public List<Nota> getNotas() {
    return notas;
  }

  public void setNotas(List<Nota> notas) {
    this.notas = notas;
  }

  public List<PersonaCursos> getPersonaCursos() {
    return personaCursos;
  }

  public void setPersonaCursos(List<PersonaCursos> personaCursos) {
    this.personaCursos = personaCursos;
  }

  public Grado getGrado() {
    return grado;
  }

  public void setGrado(Grado grado) {
    this.grado = grado;
  }

  public List<Usuario> getPersona() {
    return persona;
  }

  public void setPersona(List<Usuario> persona) {
    this.persona = persona;
  }

  public Integer getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(Integer idPersona) {
    this.idPersona = idPersona;
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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
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

  public Integer getIdGrado() {
    return idGrado;
  }

  public void setIdGrado(Integer idGrado) {
    this.idGrado = idGrado;
  }

  public LocalDateTime getFecha() {
    return fecha;
  }

  public void setFecha(LocalDateTime fecha) {
    this.fecha = fecha;
  }
}
