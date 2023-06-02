package com.eoi.petstay.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class AppParaorganizarController {
    @GetMapping("/paraorganizar/index")
    public String index( ){
        return "paraorganizar/index";
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
