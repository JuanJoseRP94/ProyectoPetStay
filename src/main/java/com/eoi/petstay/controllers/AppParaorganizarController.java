package com.eoi.petstay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppParaorganizarController {
    @GetMapping("/templates/index")
    public String index( ){
        return "/templates/index";
    }
    @GetMapping("/paraorganizar/pantallaGeneralInvitado")
    public String pantallaGeneralInvitado( ){
        return "paraorganizar/pantallaGeneralInvitado";
    }
    @GetMapping("/paraorganizar/vista_general_admin")
    public String vista_general_admin( ){
        return "paraorganizar/vista_general_admin";
    }
}
