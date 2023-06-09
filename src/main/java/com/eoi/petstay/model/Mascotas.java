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
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "foto")
    private String foto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "edad")
    private int edad;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "cartilla_vacunacion")
    private String cartillaVacunacion;
    @Column(name = "valoracion")
    private float valoracion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario")
    private Usuarios usuarios;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "raza")
    private Raza raza;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tamaños")
    private Tamanios tamanios;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comportamientos")
    private Comportamientos comportamientos;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "mascotasSet")
    private Set<TipoCuidados>  tipoCuidadosSet;
}
