package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alojamientos")
    private Set<Alojamientos> alojamientos;

}
