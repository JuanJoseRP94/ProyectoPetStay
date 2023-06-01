package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaGeneralAdminController {
    @GetMapping("/vista_general_admin")
    public  String vistaAdmin (Model model){
        String titulo = "Vista Administrador";
        model.addAttribute("titulo", titulo);
        return "vista_general_admin";
    }
}
