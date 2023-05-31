package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactanosController {
    @GetMapping("/contactanos")
    public  String detalleReserva (Model model){
        String titulo = "Contactanos";
        model.addAttribute("titulo", titulo);
        return "contactanos";
    }
}
