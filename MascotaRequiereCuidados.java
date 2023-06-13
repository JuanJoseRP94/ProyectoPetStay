package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mascota_requiere_cuidados")
public class MascotaRequiereCuidados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mascota_id")
    private Mascotas mascota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuidados_id")
    private TipoCuidados cuidados;
}