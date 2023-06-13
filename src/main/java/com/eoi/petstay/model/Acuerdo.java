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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "factura")
    private String factura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oferta")
    private Oferta oferta;
}
