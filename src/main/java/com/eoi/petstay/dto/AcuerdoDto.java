package com.eoi.petstay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcuerdoDto {
    private Long id;
    private String factura;
    private OfertaDto oferta;

    // Constructor, getters y setters
}
