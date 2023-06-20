package com.eoi.petstay.dto;

import com.eoi.petstay.model.Comportamientos;
import com.eoi.petstay.model.TipoCuidados;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OfertaDto {
    private Long id;

    private UsuarioDto usuarioOfertante;
    private UsuarioDto usuarioDemandante;
    private Date fechaInicio;
    private Date fechaFin;
    private Set<AcuerdoDto> acuerdo;

    // Constructor, getters y setters
}
