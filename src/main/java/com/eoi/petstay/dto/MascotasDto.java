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

    private Long usuarioId;

    private Long sexoId;

    private Long especieId;

    private Long tamanioId;


    private Set<Comportamientos> comportamientos = new HashSet<>();


    private Set<TipoCuidados> tipocuidados = new HashSet<>();
}
