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
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Mascotas> mascotas;
}
