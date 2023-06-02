package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gastos_gestion")
public class GastosGestion {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "tipo_contrato")
    private String tipoContrato;
    @Column(name = "descripción")
    private String descripcion;
    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario")
    private Usuarios usuarios;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Pagos> pagos;

}
