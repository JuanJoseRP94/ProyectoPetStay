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
@Table(name = "usuario")
public class Usuarios {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "foto")
    private String foto;
    @Column(name = "nombre_usuario")
    private String nombre;
    @Column(name = "apellido1")
    private String apellido;
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "valoracion")
    private String valoracion;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "password")
    private String password;

    @Basic(optional = true)
    private boolean active;

    //Un usuario solo un rol
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="usuarios")
    private Roles roles;
    @OneToOne
    @JoinColumn(name = "alojamientos")
    private Alojamientos alojamientos;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "gastos_gestion")
    private Set<GastosGestion> gastosGestion;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "valoraciones_mascotas")
    private Set<ValoracionesMascotas> valoracionesMascotas;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "valoraciones_usuarios")
    private Set<ValoracionesUsuarios> valoracionesUsuarios;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "oferta")
    private Set<Oferta> oferta;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mascotas")
    private Set<Mascotas> mascotas;

}
