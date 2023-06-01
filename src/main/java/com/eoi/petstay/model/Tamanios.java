package com.eoi.petstay.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tamaños")
public class Tamanios {
    @Id
    @Column(name = "ID")
    private int id;
    @Column
    private String nombre;


}
