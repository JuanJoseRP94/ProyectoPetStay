package com.eoi.petstay.models;

import jakarta.persistence.*;

@Entity
@Table(name="valoraciones")
public class ValoracionesMascotas {
    @Column(name = "ID")
    @Id
    private Long id;

    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "puntuacion")
    private String puntuacion;

    @ManyToOne
    @JoinColumn(name = "usuario_valorado_id")
    private Usuario usuarioValorado;

    @OneToMany
    @JoinColumn(name = "usuario_ID")
    private Usuario usuarioID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Usuario getUsuarioValorado() {
        return usuarioValorado;
    }

    public void setUsuarioValorado(Usuario usuarioValorado) {
        this.usuarioValorado = usuarioValorado;
    }

    public Usuario getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Usuario usuarioID) {
        this.usuarioID = usuarioID;
    }
}
