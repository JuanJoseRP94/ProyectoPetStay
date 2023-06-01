package com.eoi.petstay.model;

import jakarta.persistence.*;

@Entity
@Table(name="comportamientos")
public class Comportamiento {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

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
}