package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppMascotasController {

    @GetMapping("/mascotas/Perfil_Mascota")
    public String Perfil_Mascota( ){
        //Comentario
        return "mascotas/Perfil_Mascota";
    }
}
