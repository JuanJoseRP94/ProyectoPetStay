package com.eoi.petstay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AlojamientosDto {


    private Long id;
    private String foto;
    private String nombre;
    private String direccion;
    private String descripcion;
    private float valoracion;

    private Long tipo;

    private Long tamanio;

    private Long usuario;
}
