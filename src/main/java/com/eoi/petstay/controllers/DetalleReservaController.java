package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetalleReservaController {

    @GetMapping("/detalle_reserva")
    public  String detalleReserva (Model model){
        String titulo = "Detalle de la Reserva";
        model.addAttribute("titulo", titulo);
        return "usuarios/detalle_reserva";
    }
}
