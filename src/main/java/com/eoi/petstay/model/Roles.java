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
    @Column(name = "id")
    private int id;
    @Column(name = "roleName")
    private String roleName;

    //Un role puede estar asociado a muchos usuario
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Usuarios> usuarios;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu")
    private Set<Menu> menu;
}
