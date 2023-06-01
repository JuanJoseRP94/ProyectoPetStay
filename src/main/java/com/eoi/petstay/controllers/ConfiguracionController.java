package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfiguracionController {
    @GetMapping("/configuracion")
    public String configuracion(Model model) {
        String titulo = "Configuracion";
        model.addAttribute("titulo", titulo);
        return "configuracion";
    }

}
