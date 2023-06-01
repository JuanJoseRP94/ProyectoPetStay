package com.eoi.petstay.model;

import jakarta.persistence.*;


@Entity
@Table(name = "tipo_cuidados")
public class TipoCuidados {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;



}
