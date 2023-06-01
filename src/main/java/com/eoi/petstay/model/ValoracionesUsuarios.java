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
@Table(name="valoraciones")
public class ValoracionesUsuarios {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "puntuacion")
    private String puntuacion;


}
