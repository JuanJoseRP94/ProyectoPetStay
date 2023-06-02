package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mascotas")
public class Mascotas {
    @Id
    @Column(name = "ID")
    private int id;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario")
    private Usuarios usuarios;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "raza")
    private Raza raza;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tamaños")
    private Tamanios tamanios;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comportamientos")
    private Comportamientos comportamientos;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_cuidados")
    private TipoCuidados tipoCuidados;
}
