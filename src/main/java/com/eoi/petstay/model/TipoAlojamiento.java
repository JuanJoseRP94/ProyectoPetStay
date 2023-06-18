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
@Table(name = "tipo_alojamiento")
public class TipoAlojamiento {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreTipoAlojamiento")
    private String nombreTipoAlojamiento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAlojamiento")
    private Set<Alojamientos> alojamientos;
}
