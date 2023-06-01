package com.eoi.petstay.models;


import jakarta.persistence.*;


@Entity
@Table(name = "acuerdo")
public class Acuerdo {

    @Column(name = "ID") @Id
    private Long id;

    @Column(name = "factura")
    private String factura;

    @OneToMany
    @JoinColumn(name = "oferta_ID")
    private GastosGestion ofertaID;

    public Acuerdo() {
    }

    public Acuerdo(Long id, String factura, GastosGestion ofertaID) {
        this.id = id;
        this.factura = factura;
        this.ofertaID = ofertaID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public GastosGestion getOfertaID() {
        return ofertaID;
    }

    public void setOfertaID(GastosGestion ofertaID) {
        this.ofertaID = ofertaID;
    }
}
