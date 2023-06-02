package com.eoi.petstay.controllers;


import com.eoi.petstay.service.RoleService;
import com.eoi.petstay.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AppUsuariosController {

    private final UsuarioService service;
    private final RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AppUsuariosController( UsuarioService service, RoleService roleService) {
        super();
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String vistaHome( ModelMap interfazConPantalla){
        String  userName = "no informado";
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        //Comprobamos si hay usuario logeado
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            userName = "anonimo@anonimo";
        }
        else {
            userName = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        }
        interfazConPantalla.addAttribute("mensaje","El usuario logeado es:" + userName );
        return "index";
     }
    @GetMapping("/usuarios/listausuarios")
    public String listaUsuarios( ){
        return "usuarios/lista";
    }
    @GetMapping("/usuarios/login")
    public String login( ){
        return "usuarios/login";
    }


    @GetMapping("/usuarios/Busqueda_Cuidadores")
    public String Busqueda_Cuidadores( ){
        return "usuarios/Busqueda_Cuidadores";
    }
    @GetMapping("/usuarios/lista")
    public String lista( ){
        return "usuarios/lista";
    }
    @GetMapping("/usuarios/Perfil_Usuario")
    public String Perfil_Usuario( ){
        return "usuarios/Perfil_Usuario";
    }
    @GetMapping("/usuarios/registro")
    public String registro( ){
        return "usuarios/registro";
    }
    @GetMapping("/usuarios/usuarios")
    public String usuarios( ){
        return "usuarios/usuarios";
    }

}
