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
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "ID")
    private Long id;

    @Column(name = "factura")
    private String factura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oferta")
    private Oferta oferta;
}
