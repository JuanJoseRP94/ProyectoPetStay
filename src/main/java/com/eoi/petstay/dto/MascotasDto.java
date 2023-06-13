package com.eoi.petstay.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MascotasDto {

    private String foto;

    private String nombre;

    private int edad;

    private String sexo;
   
    private float valoracion;
}
