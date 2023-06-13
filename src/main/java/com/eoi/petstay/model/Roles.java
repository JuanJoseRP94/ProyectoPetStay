package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "roleName")
    private String roleName;

    //Un role puede estar asociado a muchos usuario
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role" )
    //@OneToMany(cascade = CascadeType.ALL)
    private Set<Usuarios> usuarios;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Menu> menu;
}
