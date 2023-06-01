package com.eoi.petstay.models;

import jakarta.persistence.*;


@Entity
@Table(name = "oferta")
public class Oferta {

    @Column(name = "ID") @Id
    private Long id;

    @Column(name = "valoracion_media")
    private String valoracionMedia;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "puntuacion")
    private String puntuacion;

    @OneToMany
    @JoinColumn(name = "usuario_ID")
    private Usuario usuarioID;

    public Oferta() {
    }

    public Oferta(Long id, String valoracionMedia, String comentarios, String puntuacion, Usuario usuarioID) {
        this.id = id;
        this.valoracionMedia = valoracionMedia;
        this.comentarios = comentarios;
        this.puntuacion = puntuacion;
        this.usuarioID = usuarioID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(String valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Usuario getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Usuario usuarioID) {
        this.usuarioID = usuarioID;
    }
}
