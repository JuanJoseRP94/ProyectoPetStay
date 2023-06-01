package com.eoi.petstay.models;

import jakarta.persistence.*;


@Entity
@Table(name = "mascota_requiere_cuidados")
public class MascotaRequiereCuidados {

    @OneToMany
    @JoinColumn(name = "mascotas_ID")
    private Mascotas mascotasID;

    public MascotaRequiereCuidados() {
    }

    public MascotaRequiereCuidados(Mascotas mascotasID) {
        this.mascotasID = mascotasID;
    }

    public Mascotas getMascotasID() {
        return mascotasID;
    }

    public void setMascotasID(Mascotas mascotasID) {
        this.mascotasID = mascotasID;
    }
}
