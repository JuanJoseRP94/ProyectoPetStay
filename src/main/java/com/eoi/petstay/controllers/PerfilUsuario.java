package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilUsuario {
    @GetMapping("/Perfil_Usuario")
    public  String perfilUsuario(Model model) {
        String titulo = "Perfil Usuario";
        model.addAttribute("titulo", titulo);
        return "usuarios/Perfil_Usuario";
    }
}
