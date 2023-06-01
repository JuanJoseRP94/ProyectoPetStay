package com.eoi.petstay.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pagos")
public class Pagos {

    @Column(name = "ID") @Id
    private Long id;

    @Column(name = "tipo_pago")
    private String tipoPago;
    @Column(name = "tipo_tarjeta")
    private String tipoTargeta;
    @Column(name = "estado")
    private String estado;

    @OneToMany
    @JoinColumn(name = "gastos_gestion_ID")
    private GastosGestion gastosGestionID;

    public Pagos() {
    }

    public Pagos(Long id, String tipoPago, String tipoTargeta, String estado, GastosGestion gastosGestion) {
        this.id = id;
        this.tipoPago = tipoPago;
        this.tipoTargeta = tipoTargeta;
        this.estado = estado;
        this.gastosGestionID = gastosGestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getTipoTargeta() {
        return tipoTargeta;
    }

    public void setTipoTargeta(String tipoTargeta) {
        this.tipoTargeta = tipoTargeta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public GastosGestion getGastosGestion() {
        return gastosGestionID;
    }

    public void setGastosGestion(GastosGestion gastosGestion) {
        this.gastosGestionID = gastosGestion;
    }
}
