package com.eoi.petstay.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String uri;     //Indica dónde está el archivo de la imagen. OJO Será una ruta DEL SERVIDOR. DEBE PROTEGERSE

    public Imagen(String nombre, String uri) {
        this.nombre = nombre;
        this.uri = uri;
    }
}
