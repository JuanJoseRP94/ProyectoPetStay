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
@Table(name = "tamaños")
public class Tamanios {
    @Id
    @Column(name = "ID")
    private int id;

    @Column
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mascotas")
    private Set<Mascotas> mascotas;
}
