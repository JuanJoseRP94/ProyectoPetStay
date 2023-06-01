package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroController {

    @GetMapping("/login")
    public  String iniciarSesion (Model model){
        String titulo = "Registro";
        model.addAttribute("titulo", titulo);
        return "login";
    }

    @GetMapping("/registro")
    public  String buscarAlojamiento (Model model){
        String titulo = "Registro";
        model.addAttribute("titulo", titulo);
        return "registro";
    }

    @GetMapping("/olv-contrasena")
    public  String olvidasteContrasena (Model model){
        String titulo = "Olvidaste Contraseña";
        model.addAttribute("titulo", titulo);
        return "olv-contrasena";
    }
}
