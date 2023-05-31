package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/index")
    public  String index(Model model){
        String titulo = "Inicio";
        model.addAttribute("titulo", titulo);
        return "index";
    }
}