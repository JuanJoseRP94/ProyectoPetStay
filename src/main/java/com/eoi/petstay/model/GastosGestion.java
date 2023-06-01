package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    //@OneToMany
    //@JoinColumn(name = "usuario_ID")
    //private Usuario usuarioID;




}
