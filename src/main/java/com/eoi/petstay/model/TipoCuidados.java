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
@Table(name = "tipo_cuidados")
public class TipoCuidados {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "nombre")
    private String nombreCuidado;
    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Mascotas> mascotasSet;
}
