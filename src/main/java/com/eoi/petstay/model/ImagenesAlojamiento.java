package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "imagenes_alojamiento")
public class ImagenesAlojamiento {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "url")
    private String url;

    //@OneToMany
    //@JoinColumn(name = "alojamientos_ID")
    //private Alojamientos alojamientosID;


}