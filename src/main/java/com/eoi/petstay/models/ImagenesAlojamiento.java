package com.eoi.petstay.models;

import jakarta.persistence.*;

@Entity
@Table(name = "imagenes_alojamiento")
public class ImagenesAlojamiento {

    @Column(name = "ID") @Id
    private Long id;

    @Column(name = "url")
    private String url;

    @OneToMany
    @JoinColumn(name = "alojamientos_ID")
    private Alojamientos alojamientosID;

    public ImagenesAlojamiento() {
    }

    public ImagenesAlojamiento(Long id, String url, Alojamientos alojamientosID) {
        this.id = id;
        this.url = url;
        this.alojamientosID = alojamientosID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Alojamientos getAlojamientosID() {
        return alojamientosID;
    }

    public void setAlojamientosID(Alojamientos alojamientosID) {
        this.alojamientosID = alojamientosID;
    }
}
