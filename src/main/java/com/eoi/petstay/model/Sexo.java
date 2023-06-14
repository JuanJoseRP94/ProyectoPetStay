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
@Table(name = "sexo")
public class Sexo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descripcion")
    private String descripcion;

    //Un role puede estar asociado a muchos usuario
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sexo" )
    //@OneToMany(cascade = CascadeType.ALL)
    private Set<Mascotas> mascotas;

}
