package com.eoi.petstay.dto;

import com.eoi.petstay.model.Comportamientos;
import com.eoi.petstay.model.TipoCuidados;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventoDto {
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
