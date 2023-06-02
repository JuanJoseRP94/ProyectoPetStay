package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Raza {
    @Id
    @Column(name = "ID")

    private int id;
    @Column
    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "especie")
     private Especie especie;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "mascota")
    private Set<Mascotas> mascotas;

    }
