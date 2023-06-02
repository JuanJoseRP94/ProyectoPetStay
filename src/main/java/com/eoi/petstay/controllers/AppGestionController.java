package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppGestionController {
    @GetMapping("/gestion/calendario")
    public String calendario( ){
        return "gestion/calendario";
    }
    @GetMapping("/gestion/configuracion")
    public String configuracion( ){
        return "gestion/configuracion";
    }
    @GetMapping("/gestion/contactanos")
    public String contactanos( ){
        return "gestion/contactanos";
    }
    @GetMapping("/gestion/olv_contrasena")
    public String olv_contrasena( ){
        return "gestion/olv_contrasena";
    }
}
