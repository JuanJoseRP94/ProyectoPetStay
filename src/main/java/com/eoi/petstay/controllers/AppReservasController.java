package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppReservasController {
    @GetMapping("/reservas/detalle_reserva")
    public String detalle_reserva( ){ return "reservas/detalle_reserva"; }
    @GetMapping("/reservas/Pagos")
    public String Pagos( ){ return "reservas/Pagos"; }
}
