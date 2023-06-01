package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilAlojamientoController {

    @GetMapping("/Perfil_Alojamiento")
    public  String perfilMascotas(Model model) {
        String titulo = "Perfil Alojamientos";
        model.addAttribute("titulo", titulo);
        return "usuarios/Perfil_Alojamiento";
    }
}
