package com.eoi.petstay.controllers;

import com.eoi.petstay.model.*;
import com.eoi.petstay.service.OfertaService;
import com.eoi.petstay.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class AppOfertaController {

    private final OfertaService ofertaService;
    private final UsuarioService usuarioService;

    public AppOfertaController(OfertaService ofertaService, UsuarioService usuarioService) {
        this.ofertaService = ofertaService;
        this.usuarioService = usuarioService;
    }

    // CREACIÓN DE OFERTAS
    @GetMapping("/oferta/crearoferta")
    public String mostrarFormularioOferta(Model model, Principal principal) {
        String ofertanteEmail = principal.getName();
        Optional<Usuario> ofertanteOptional = usuarioService.getRepo().findUsuarioByEmailAndActiveTrue(ofertanteEmail);
        if (ofertanteOptional.isEmpty()) {
            return "redirect:/usuario/usuarionoexiste";
        }
        Usuario ofertante = ofertanteOptional.get();

        model.addAttribute("usuario", ofertante);
        model.addAttribute("alojamiento", ofertante.getAlojamientos());
        model.addAttribute("mascotas", ofertante.getMascotas());

        return "oferta/crearoferta";
    }

    @PostMapping("/oferta/crearoferta")
    public String crearOferta(@ModelAttribute OfertaCrear request, Principal principal) {
        String ofertanteEmail = principal.getName();
        Optional<Usuario> ofertanteOptional = usuarioService.getRepo().findUsuarioByEmailAndActiveTrue(ofertanteEmail);
        if (ofertanteOptional.isEmpty()) {
            return "redirect:/usuario/usuarionoexiste";
        }
        Usuario ofertante = ofertanteOptional.get();

        Oferta oferta = new Oferta();
        oferta.setUsuarioOfertante(ofertante);
        oferta.setFechaInicio(request.getFechaInicio());
        oferta.setFechaFin(request.getFechaFin());

        ofertaService.crearOferta(oferta);

        return "redirect:/oferta/detalleoferta";
    }

}
