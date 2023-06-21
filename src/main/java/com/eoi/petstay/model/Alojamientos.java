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
@Table(name = "alojamientos")
public class Alojamientos {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "foto")
    private String foto;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valoracion_media")
    private float valoracionMedia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ImagenesAlojamiento> imagenesAlojamiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoAlojamiento")
    private TipoAlojamiento tipoAlojamiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tamanioAlojamiento")
    private TamanioAlojamiento tamanioAlojamiento;
}