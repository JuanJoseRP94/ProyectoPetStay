package com.eoi.petstay.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Column(name = "ID") @Id
    private Long id;

    @Column(name = "foto")
    private String foto;
    @Column(name = "nombre_usuario")
    private String nombre;
    @Column(name = "apellido1")
    private String apellido;
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "valoracion")
    private String valoracion;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "password")
    private String password;
    @OneToOne
    @JoinColumn(name = "roles_id_rol")
    private Roles rol;
    @OneToOne
    @JoinColumn(name = "alojamientos_id")
    private Alojamientos alojamientos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol() {
    }

    public Alojamientos getAlojamientos() {
        return alojamientos;
    }

    public void setAlojamientos() {
    }

    public Usuario() {
    }

    public Usuario(Long id, String foto, String nombre, String apellido, String apellido2, String valoracion, String sexo, String email, String telefono, String password, Roles rol, Alojamientos alojamientos) {
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.valoracion = valoracion;
        this.sexo = sexo;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.rol = rol;
        this.alojamientos = alojamientos;
    }
}
