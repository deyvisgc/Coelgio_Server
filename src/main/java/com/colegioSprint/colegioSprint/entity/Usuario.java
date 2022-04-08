package com.colegioSprint.colegioSprint.entity;

import com.colegioSprint.colegioSprint.dto.UsersJoin;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@NamedNativeQuery(name = "Usuario.getUsersClass",
                  query = "select u.id_persona, u.usuario, u.password, r.nombre_rol, p.nombre, p.apellidos, " +
                          "p.codigo_interno codigoInterno, p.email, p.fecha_creacion fecha " +
                          "from usuario u join rol r on u.id_rol = r.id_rol join persona p on u.id_persona = p.id_persona",
                   resultSetMapping = "Mapping.UsersJoin")
@NamedNativeQuery(name = "Usuario.getUsersClassById",
        query = "select u.id_persona, u.usuario, u.password, r.nombre_rol, p.nombre, p.apellidos, " +
                "p.codigo_interno codigoInterno, p.email, p.fecha_creacion fecha " +
                "from usuario u join rol r on u.id_rol = r.id_rol join persona p on u.id_persona = p.id_persona where u.id_persona = ?",
        resultSetMapping = "Mapping.UsersJoin")
@SqlResultSetMapping(name = "Mapping.UsersJoin",
        classes = @ConstructorResult(targetClass = UsersJoin.class,
                columns = {
                            @ColumnResult(name = "id_persona"),
                            @ColumnResult(name = "usuario"),
                            @ColumnResult(name = "password"),
                            @ColumnResult(name = "nombre_rol"),
                            @ColumnResult(name = "nombre"),
                            @ColumnResult(name = "apellidos"),
                            @ColumnResult(name = "codigoInterno"),
                            @ColumnResult(name = "email"),
                            @ColumnResult(name = "fecha", type = LocalDateTime.class)
        }))
public class Usuario{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  private Integer idUsuario;
  @Column(unique = true)
  private String  usuario;
  private String  password;
  @Column(name = "id_rol")
  private Integer idRol;
  @Column(name = "id_persona")
  private Integer idPersona;

  public Usuario(String usuario, String password, Integer idRol, Integer idPersona) {
    this.usuario = usuario;
    this.password = password;
    this.idRol = idRol;
    this.idPersona = idPersona;
  }

  public Usuario() {
  }
  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_persona", insertable = false, updatable = false)
  private Persona persona;
  @JsonIgnore
  @ManyToOne()
  @JoinColumn(name = "id_rol", updatable = false, insertable = false)
  private Rol rol;

  public Integer getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(Integer idPersona) {
    this.idPersona = idPersona;
  }

  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

  public Rol getRol() {
    return rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
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

  public Integer getIdRol() {
    return idRol;
  }

  public void setIdRol(Integer idRol) {
    this.idRol = idRol;
  }
}
