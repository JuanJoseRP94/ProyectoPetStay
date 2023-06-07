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
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "ID")

    private int id;
    @Column
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "especie")
     private Especie especie;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Mascotas> mascotas;

    }
