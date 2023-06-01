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
@Table(name = "acuerdo")
public class Acuerdo {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "factura")
    private String factura;

    //@OneToMany
    //@JoinColumn(name = "oferta_ID")
    //private GastosGestion ofertaID;



}
