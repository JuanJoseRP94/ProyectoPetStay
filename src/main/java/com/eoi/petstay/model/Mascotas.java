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
@Table(name = "mascotas")
public class Mascotas {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "foto")
    private String foto;
    @Column(name = "nombreMascota")
    private String nombreMascota;
    @Column(name = "edad")
    private int edad;
    @Column(name = "valoracion")
    private float valoracion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "especie")
    private Especie especie;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tamanio")
    private Tamanios tamanio;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Comportamientos> comportamientos;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<TipoCuidados>  tipoCuidados;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sexo")
    private Sexo sexo;
}

