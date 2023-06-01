package com.eoi.petstay.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "gastos_gestion")
public class GastosGestion {

    @Column(name = "ID") @Id
    private Long id;

    @Column(name = "tipo_contrato")
    private String tipoContrato;
    @Column(name = "descripción")
    private String descripcion;
    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @OneToMany
    @JoinColumn(name = "usuario_ID")
    private Usuario usuarioID;

    public GastosGestion() {
    }

    public GastosGestion(Long id, String tipoContrato, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin, Usuario usuarioID) {
        this.id = id;
        this.tipoContrato = tipoContrato;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuarioID = usuarioID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Usuario getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Usuario usuarioID) {
        this.usuarioID = usuarioID;
    }
}
