package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oferta")
public class Oferta {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valoracion_media")
    private String valoracionMedia;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "puntuacion")
    private String puntuacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_oferta")
    private Usuario usuarioOfertante;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_demanda")
    private Usuario usuarioDemandante;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Acuerdo> acuerdo;
}
