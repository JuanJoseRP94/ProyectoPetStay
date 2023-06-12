package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppValoracionesController {
    @GetMapping("/valoraciones/Valoraciones2")
    public String Valoraciones2( ){
        return "valoraciones/Valoraciones2";
    }
}
