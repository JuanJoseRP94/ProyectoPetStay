package com.eoi.petstay.controllers;

import com.eoi.petstay.service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VariosCtrl {
    @Autowired
    private AlojamientoService alojaSrvc;

    @GetMapping({"","/"})
    public String inicio(Model modelo){
        modelo.addAttribute("alojamientos", alojaSrvc.obtenerTodos());

        return "inicio";
    }
}
