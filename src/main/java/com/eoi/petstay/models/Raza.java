package com.eoi.petstay.models;

import jakarta.persistence.*;

@Entity
@Table
public class Raza {
    @Column(name = "ID")
    @Id
    private int id;
    @Column
    private String nombre;
    @JoinColumn
    @OneToMany
    private Especie especie;

    public Raza() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
