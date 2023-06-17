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
@Table(name = "sexousuario")
public class SexoUsuario {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descripcion")
    private String descripcion;

    //Un role puede estar asociado a muchos usuario
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sexousuario" )
    //@OneToMany(cascade = CascadeType.ALL)
    private Set<Usuarios> usuarios;

}