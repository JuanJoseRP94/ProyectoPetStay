package com.eoi.petstay.controllers;

import com.eoi.petstay.model.Usuarios;
import com.eoi.petstay.service.UsuarioService;
import org.springframework.ui.Model;

import com.eoi.petstay.model.Alojamientos;
import com.eoi.petstay.service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/alojamientos")
public class AppAlojamientosController {
    @Autowired
    private UsuarioService usuarioService;
    private final AlojamientoService alojamientoService;
    @Autowired
    public AppAlojamientosController(AlojamientoService alojamientoService) {
        this.alojamientoService = alojamientoService;
    }
    @GetMapping
    public String obtenerAlojamientos(Model model) {
        List<Alojamientos> alojamientos = alojamientoService.obtenerAlojamientos();
        model.addAttribute("alojamientos", alojamientos);
        return "alojamientos/lista";
    }
    @GetMapping("/registro")
    public String vistaRegistro(Model model) {
        model.addAttribute("alojamiento", new Alojamientos());
        return "alojamientos/registro";
    }
    @PostMapping("/registro")
    public String guardarAlojamiento(@ModelAttribute("alojamiento") Alojamientos alojamiento) {
        alojamientoService.guardarAlojamiento(alojamiento);
        return "redirect:/alojamientos";
    }
    @GetMapping("/{id}")
    public String obtenerAlojamientoPorId(@PathVariable("id") Long id, Model model) {
        Optional<Alojamientos> alojamiento = alojamientoService.obtenerAlojamientoPorId(id);
        if (alojamiento.isPresent()) {
            model.addAttribute("alojamiento", alojamiento.get());
            return "alojamientos/detalles";
        }
        return "redirect:/alojamientos";
    }
    @GetMapping("/{id}/editar")
    public String editarAlojamiento(@PathVariable("id") Long id, Model model) {
        Optional<Alojamientos> alojamiento = alojamientoService.obtenerAlojamientoPorId(id);
        if (alojamiento.isPresent()) {
            model.addAttribute("alojamiento", alojamiento.get());
            return "alojamientos/edicion";
        }
        return "redirect:/alojamientos";
    }
    @PostMapping("/{id}/actualizar")
    public String actualizarAlojamiento(@PathVariable("id") Long id, @ModelAttribute("alojamiento") Alojamientos alojamientoActualizado) {
        alojamientoService.actualizarAlojamiento(id, alojamientoActualizado);
        return "redirect:/alojamientos";
    }
    @PostMapping("/{id}/eliminar")
    public String eliminarAlojamiento(@PathVariable("id") Long id) {
        alojamientoService.eliminarAlojamiento(id);
        return "redirect:/alojamientos";
    }
    @GetMapping("/alojamientos/buscar_alojamientos")
    public String buscar_alojamientos( ){
        return "alojamientos/buscar_alojamientos";
    }
    @GetMapping("/alojamientos/Perfil_Alojamiento")
    public String Perfil_Alojamiento( ){
        return "alojamientos/Perfil_Alojamiento";
    }

    @GetMapping("/alojamientos/publicar")
    public String mostrarFormularioPublicacion(Model model) {

        List<Usuarios> usuarios = UsuarioService.obtenerTodos();
        model.addAttribute("usuarios", usuarios);


        model.addAttribute("alojamiento", new Alojamientos());

        return "alojamientos/formulario-publicacion";
    }
}
