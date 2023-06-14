package com.eoi.petstay.controllers;

import com.eoi.petstay.model.Usuarios;
import com.eoi.petstay.service.UsuarioService;
import org.springframework.ui.Model;

import com.eoi.petstay.model.Alojamientos;
import com.eoi.petstay.service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.eoi.petstay.repository.AlojamientoRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AppAlojamientosController {
    private final AlojamientoService alojamientoService;
    private final UsuarioService usuarioService;

    public AppAlojamientosController(AlojamientoService alojamientoService, UsuarioService usuarioService) {
        this.alojamientoService = alojamientoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/alojamientos/Perfi_lAlojamiento")
    public String perfilAlojamiento() {
        return "alojamientos/Perfil_Alojamiento";
    }

    @GetMapping("/alojamientos/Lista_Alojamientos")
    public String getAllPaginated(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @NotNull Model model) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Alojamientos> alojamientosPage = alojamientoService.getRepo().findAll(pageable);

        model.addAttribute("alojamientos", alojamientosPage);

        int totalPages = alojamientosPage.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("Alojamientos", alojamientosPage);
        }

        return "alojamientos/Lista_Alojamientos";
    }

    @GetMapping("/alojamientos/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Alojamientos> alojamiento = alojamientoService.encuentraPorId(id);
        model.addAttribute("alojamiento", alojamiento);
        return "alojamientos/detalles_alojamiento";
    }

        @GetMapping("/alojamientos/registro_alojamiento")
        public String registroAlojamiento(Model interfazConPantalla) {
            // Instancia en memoria del objeto a informar en la pantalla
            final Alojamientos alojamiento = new Alojamientos();

            interfazConPantalla.addAttribute("datosAlojamiento", alojamiento);
            System.out.println("Preparando registro de alojamiento");
            return "alojamientos/registro_alojamiento";
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
    @PostMapping("alojamientos/registro_alojamiento")
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

    @GetMapping("/alojamientos/publicar")
    public String mostrarFormularioPublicacion(Model model) {

        List<Usuarios> usuarios = usuarioService.obtenerTodos();
        model.addAttribute("usuarios", usuarios);


        model.addAttribute("alojamiento", new Alojamientos());

        return "alojamientos/formulario-publicacion";
    }
}
