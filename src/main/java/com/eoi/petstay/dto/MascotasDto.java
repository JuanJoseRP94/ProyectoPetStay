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
    private String foto;
    private String nombre;
    private int edad;
    private String sexo;
    private float valoracion;


    // Dependencias

    private Integer usuarioId;

    private Integer sexoId;

    private Integer especieId;

    private Integer tamanioId;

    private Integer comportamientosId;
    private Set<Comportamientos> comportamientos = new HashSet<>();

    private Integer tipoCuidadosId;
    private Set<TipoCuidados> tipoCuidados = new HashSet<>();
}
