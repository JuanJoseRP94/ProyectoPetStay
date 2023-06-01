package com.eoi.petstay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mascotas")
public class Mascotas {
    @Id
    @Column(name = "ID")

    private int id;

    @Column(name = "foto")
    private String foto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "edad")
    private int edad;
    ;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "cartilla_vacunacion")
    private String cartillaVacunacion;
    @Column(name = "valoracion")
    private float valoracion;

}
