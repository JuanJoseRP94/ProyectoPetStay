package com.eoi.petstay.controllers;


import com.eoi.petstay.dto.Email;
import com.eoi.petstay.dto.RecuperarContrasenaDto;
import com.eoi.petstay.model.Usuario;
import com.eoi.petstay.repository.UsuarioRepository;
import com.eoi.petstay.service.EmailService;
import com.eoi.petstay.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppEmailRecContrController {
    private final UsuarioService usuarioService;
    private final EmailService emailservice;
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private JavaMailSender sender;

    public AppEmailRecContrController(UsuarioService service, EmailService emailservice,
                                      UsuarioRepository usuarioRepository) {
        this.usuarioService = service;
        this.emailservice = emailservice;
        this.usuarioRepository = usuarioRepository;
    }
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    //Cambio de password
    @GetMapping("/email/olv_contrasena")
    public String reestablecerContrasena(@ModelAttribute(name = "loginForm") RecuperarContrasenaDto recuperarContrasenaDto) throws Exception {
        return "email/olv_contrasena";
    }

    @PostMapping("/email/olv_contrasena")
    public String enviarContrasena (@RequestParam ("username") String correo){
        //Comprobamos que existe el usuario por email y password
        if (usuarioService.getRepo().repValidarEmail(correo) > 0)
        {
            // Buscamos el usuario
            Usuario usuario = usuarioService.getRepo().findUsuarioByEmail(correo);
            Email emailRecContr = new Email();
            String recuperarContrasenaURL = "http://localhost:8099/email/recuperarcontrasena";

            // Lógica para inicializar los valores de emailRecContr si es necesario


            emailRecContr.setFrom("notificaciones@agestturnos.es");
            emailRecContr.setTo(usuario.getEmail());
            emailRecContr.setSubject("Recuperación de contraseña");
            emailRecContr.setContent("<a href='" + recuperarContrasenaURL + "'>Haz clic aquí</a> para recuperar tu contraseña.");
            emailservice.sendMail(emailRecContr);

            return "email/emailexitoso";
        }else {
            return "usuario/usuarionoexiste";
        }
    }


}
