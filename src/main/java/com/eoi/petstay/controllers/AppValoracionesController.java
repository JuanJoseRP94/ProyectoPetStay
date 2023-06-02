package com.eoi.petstay.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class AppValoracionesController {
    @GetMapping("/valoraciones/Valoraciones2")
    public String Valoraciones2( ){
        return "valoraciones/Valoraciones2";
    }
}
