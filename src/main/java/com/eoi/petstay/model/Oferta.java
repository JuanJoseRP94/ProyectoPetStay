package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oferta")
public class Oferta {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "valoracion_media")
    private String valoracionMedia;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "puntuacion")
    private String puntuacion;




}