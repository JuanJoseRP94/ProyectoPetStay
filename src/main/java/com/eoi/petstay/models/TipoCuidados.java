package com.eoi.petstay.models;

import jakarta.persistence.*;


@Entity
@Table(name = "tipo_cuidados")
public class TipoCuidados {

    @Column(name = "ID") @Id
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany
    @JoinColumn(name = "mascota_requiere_cuidados_ID")
    private MascotaRequiereCuidados mascotaRequiereCuidadosID;

    public TipoCuidados() {
    }

    public TipoCuidados(Long id, String nombre, String descripcion, MascotaRequiereCuidados mascotaRequiereCuidadosID) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.mascotaRequiereCuidadosID = mascotaRequiereCuidadosID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public MascotaRequiereCuidados getMascotaRequiereCuidadosID() {
        return mascotaRequiereCuidadosID;
    }

    public void setMascotaRequiereCuidadosID(MascotaRequiereCuidados mascotaRequiereCuidadosID) {
        this.mascotaRequiereCuidadosID = mascotaRequiereCuidadosID;
    }
}
