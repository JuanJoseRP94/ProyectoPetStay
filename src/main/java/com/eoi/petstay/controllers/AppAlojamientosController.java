package com.eoi.petstay.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class AppAlojamientosController {
    @GetMapping("/alojamientos/buscar_alojamientos")
    public String buscar_alojamientos( ){
        return "alojamientos/buscar_alojamientos";
    }
    @GetMapping("/alojamientos/Perfil_Alojamiento")
    public String Perfil_Alojamiento( ){
        return "alojamientos/Perfil_Alojamiento";
    }
}
