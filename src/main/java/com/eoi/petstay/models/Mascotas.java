package com.eoi.petstay.models;

import jakarta.persistence.*;

@Entity
@Table(name = "mascotas")
public class Mascotas {
    @Column(name = "ID")
    @Id
    private int id;

    @Column(name = "foto")
    private String foto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "edad")
    private int edad;
    @Column(name = "raza_id")
    private Raza raza;
    @Column(name = "tamaño_id")
    private Tamanios tamanios;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "cartilla_vacunacion")
    private String cartillaVacunacion;
    @Column(name = "valoracion")
    private float valoracion;
    @OneToMany
    @JoinColumn(name = "usuario_ID")
    private Usuario usuarioID;
}
