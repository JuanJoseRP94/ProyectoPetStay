package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pagos")
public class Pagos {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "tipo_pago")
    private String tipoPago;
    @Column(name = "tipo_tarjeta")
    private String tipoTargeta;
    @Column(name = "estado")
    private String estado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gastos_gestion")
    private GastosGestion gastosGestion;

}
