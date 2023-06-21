package com.eoi.petstay.dto;

import com.eoi.petstay.model.Comportamientos;
import com.eoi.petstay.model.TipoCuidados;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MascotasDto {

    private long id;
    private String fotoConRuta;
    private String nombre;
    private int edad;
    private float valoracion;

    // Dependencias

    private Long usuario;

    private Long sexo;
    private Long especie;
    private Long tamanio;
    private Set<Comportamientos> comportamientos = new HashSet<>();
    private Set<TipoCuidados> tipoCuidados = new HashSet<>();
}
