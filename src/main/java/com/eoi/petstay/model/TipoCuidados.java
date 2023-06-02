package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_cuidados")
public class TipoCuidados {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mascotas")
    private Mascotas mascotas;
}
