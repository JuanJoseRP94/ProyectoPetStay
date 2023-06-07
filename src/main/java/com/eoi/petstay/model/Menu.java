package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    private Menu parent;
    @Column(name = "AppOrder")
    private Integer order;
    private Integer active;
    private String url;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Roles> roles;
}
