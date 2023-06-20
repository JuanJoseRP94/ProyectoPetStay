package com.eoi.petstay.controllers;


import com.eoi.petstay.dto.LoginDto;
import com.eoi.petstay.model.Roles;
import com.eoi.petstay.model.Usuario;
import com.eoi.petstay.config.IUsuarioServicio;
import com.eoi.petstay.service.RoleService;
import com.eoi.petstay.service.UsuarioService;
import com.eoi.petstay.util.ValidarFormatoPassword;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller

public class AppUsuarioController {

    private final UsuarioService service;
    private final RoleService roleService;
    @Autowired
    private IUsuarioServicio userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AppUsuarioController(UsuarioService service, RoleService roleService) {
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

    @GetMapping("/usuario/login")
    public String login( ){
        return "usuario/login";
    }
    @PostMapping("/usuario/login")
    public String validarPasswordPst(@ModelAttribute(name = "loginForm" ) LoginDto loginDto) {
        String usr = loginDto.getUsername();
        System.out.println("usr :" + usr);
        String password = loginDto.getPassword();
        System.out.println("pass :" + password);
        //¿es correcta la password?
        Optional<Usuario> usuario = service.getRepo().findByEmailAndPasswordAndActiveTrue(usr, passwordEncoder.encode(password));
        if (usuario.isPresent())
        {
            return "index";
        }else {
            return "usuario/login";
        }
    }

    @GetMapping("/usuario/Busqueda_Cuidadores")
    public String Busqueda_Cuidadores( ){
        return "usuario/Busqueda_Cuidadores";
    }



    //Listas y paginar los usuario

    @GetMapping("/usuario/lista")
    public String getAllPaginated(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  Model model) {

        Pageable pageable = PageRequest.of(page-1, size);
        Page<Usuario> usuarioPage = service.buscarTodos(pageable);

        model.addAttribute("usuario", usuarioPage);

        int totalPages = usuarioPage.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "usuario/lista";
    }


    @GetMapping("/usuario/{id}")
        public String editar(@PathVariable Long id, Model model){
        Optional<Usuario> usuario = service.encuentraPorId(id);
        model.addAttribute("usuario", usuario);
        return "usuario/detalles_usuario";
    }



    @GetMapping("/usuario/Perfil_Usuario")
    public String Perfil_Usuario( ){
        return "usuario/Perfil_Usuario";
    }


    //Para crear un usuario hay dos bloques
    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
    @GetMapping("/usuario/registro")
    public String vistaRegistro(Model interfazConPantalla){
        //Instancia en memoria del dto a informar en la pantalla
        final Usuario usuario = new Usuario();
        //Obtengo la lista de roles
        final Set<Roles> roles = roleService.buscarTodos();
        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datosUsuario",usuario);
        interfazConPantalla.addAttribute("listaRoles", roles);
        System.out.println("Preparando pantalla registro");
        return "usuario/registro";
    }
    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("/usuario/registro")
    public String guardarUsuario( @ModelAttribute(name ="datosUsuario") Usuario usuario) throws Exception {
        //Guardamos el usuario
        if (ValidarFormatoPassword.ValidarFormato(usuario.getPassword())){
            //Tenemos que codificar la password antes de guardarla en la base de datos
            String passwordcodificada = userService.getEncodedPassword(usuario);
            //Sustituimos la password
            usuario.setPassword(passwordcodificada);
            usuario.setActive(true);
            if (Objects.isNull(usuario.getRole())){
                usuario.setRole(roleService.getRepo().findByRoleName("ROLE_USER"));
            }
            //Guardamos el usuario
            Usuario usuarioguardado = this.service.guardar(usuario);
            //Vamos a la pantalla de login
            return "usuario/login";
        }
        else
        {
            return "usuario/registro";
        }


    }

    @ModelAttribute("loggedIn")
    public boolean getLoggedInStatus() {
        return !SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser");
    }



}
