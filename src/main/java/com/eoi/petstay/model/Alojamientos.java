package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Alojamientos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private int id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valoracion_media")
    private float valoracionMedia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarios")
    private Usuarios usuarios;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ImagenesAlojamiento> imagenesAlojamiento;
}