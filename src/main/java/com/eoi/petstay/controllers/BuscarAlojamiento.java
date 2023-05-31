package com.eoi.petstay.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuscarAlojamiento {
    @GetMapping("/buscar_alojamientos")
    public  String buscarAlojamiento (Model model){
        String titulo = "Buscar Alojamiento";
        model.addAttribute("titulo", titulo);
        return "buscar_alojamientos";
    }
}
