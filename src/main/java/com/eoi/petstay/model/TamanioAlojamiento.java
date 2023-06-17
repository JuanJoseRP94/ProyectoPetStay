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
@Table(name = "tamanio_alojamiento")
public class TamanioAlojamiento {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombreTamanioAlojamiento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tamanioAlojamiento")
    private Set<Alojamientos> alojamientos;
}
