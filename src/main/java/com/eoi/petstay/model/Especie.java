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
@Table(name = "especie")
public class Especie {
    @Id
    @Column(name = "ID")
    private int id;

    @Column
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "raza")
    private Set<Raza> raza;

}
