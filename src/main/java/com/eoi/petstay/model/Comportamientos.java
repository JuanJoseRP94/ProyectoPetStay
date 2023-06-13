
package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="comportamientos")
public class Comportamientos {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreComportamientos")
    private String nombreComportamientos;

    @OneToMany(mappedBy = "comportamiento", cascade = CascadeType.ALL)
    private Set<MascotaHasComportamientos> mascotaHasComportamientos;
}