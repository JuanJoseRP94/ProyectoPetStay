package com.eoi.petstay.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class AppReservasController {
    @GetMapping("/reservas/detalle_reserva")
    public String detalle_reserva( ){ return "reservas/detalle_reserva"; }
    @GetMapping("/reservas/Pagos")
    public String Pagos( ){ return "reservas/Pagos"; }
}
