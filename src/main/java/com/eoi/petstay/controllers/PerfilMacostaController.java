package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilMacostaController {

    @GetMapping("/Perfil_Mascota")
    public  String perfilMascotas(Model model){
        String titulo = "Perfil Mascotas";
        model.addAttribute("titulo", titulo);
        return "mascotas/Perfil_Mascota";
    }
}
