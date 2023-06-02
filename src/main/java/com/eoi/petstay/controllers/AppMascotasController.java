package com.eoi.petstay.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class AppMascotasController {

    @GetMapping("/mascotas/Perfil_Mascota")
    public String Perfil_Mascota( ){
        return "mascotas/Perfil_Mascota";
    }
}
