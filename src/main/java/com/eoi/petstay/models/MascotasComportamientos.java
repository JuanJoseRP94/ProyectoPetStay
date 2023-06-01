package com.eoi.petstay.models;

import jakarta.persistence.*;


@Entity
@Table(name = "mascotas_comportamientos")
public class MascotasComportamientos {

    @OneToMany
    @JoinColumn(name = "mascotas_ID")
    private Mascotas mascotasID;

    @OneToMany
    @JoinColumn(name = "comportamiento_id")
    private Comportamiento comportamientoID;

    public Mascotas getMascotasID() {
        return mascotasID;
    }

    public void setMascotasID(Mascotas mascotasID) {
        this.mascotasID = mascotasID;
    }

    public Comportamiento getComportamientoID() {
        return comportamientoID;
    }

    public void setComportamientoID(Comportamiento comportamientoID) {
        this.comportamientoID = comportamientoID;
    }
}