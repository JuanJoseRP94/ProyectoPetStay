package com.eoi.petstay.controllers;

import com.eoi.petstay.dto.AlojamientosDto;
import com.eoi.petstay.model.*;
import com.eoi.petstay.repository.AlojamientoRepository;
import com.eoi.petstay.repository.TamanioAlojamientoRepository;
import com.eoi.petstay.repository.TipoAlojamientoRepository;
import com.eoi.petstay.service.UsuarioService;
import org.springframework.ui.Model;

import com.eoi.petstay.service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private final AlojamientoService alojamientoService;


    @Autowired
    private final TipoAlojamientoRepository tipoAlojamientoRepository;
    @Autowired
    private final TamanioAlojamientoRepository tamanioAlojamientoRepository;

    @Autowired
    private final UsuarioService usuarioService;

    public AppAlojamientosController(AlojamientoService alojamientoService, AlojamientoRepository alojamientoRepository, TipoAlojamientoRepository tipoAlojamientoRepository, TamanioAlojamientoRepository tamanioAlojamientoRepository, UsuarioService usuarioService) {
        super();
        this.alojamientoService = alojamientoService;
        this.tipoAlojamientoRepository = tipoAlojamientoRepository;
        this.tamanioAlojamientoRepository = tamanioAlojamientoRepository;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/alojamientos/Perfil_Alojamiento")
    public String perfilAlojamiento() {
        return "alojamientos/Perfil_Alojamiento";
    }

    @GetMapping("/alojamientos/Listaalojamientos")
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
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "alojamientos/Lista_Alojamientos";
    }



        @GetMapping("/alojamientos/registro_alojamiento")
        public String registroAlojamiento(Model interfazConPantalla) {
            // Instancia en memoria del objeto a informar en la pantalla
            final AlojamientosDto alojamientoDto = new AlojamientosDto();

            List<TamanioAlojamiento> tamanioAlojamientoList = tamanioAlojamientoRepository.findAll();
            List<TipoAlojamiento> tipoAlojamientoList = tipoAlojamientoRepository.findAll();

            interfazConPantalla.addAttribute("datosAlojamiento", alojamientoDto);
            interfazConPantalla.addAttribute("listaTipoAlojamiento", tipoAlojamientoList);
            interfazConPantalla.addAttribute("listaTamaniosAlojamiento", tamanioAlojamientoList);




            return "alojamientos/registro_alojamiento";
        }



    @PostMapping("/alojamientos/registro_alojamiento")
    public String guardarAlojamiento(@ModelAttribute("datosAlojamiento") AlojamientosDto alojamientoDto) throws Exception {
        Alojamientos alojamientos = new Alojamientos();

        alojamientos.setNombre(alojamientoDto.getNombre());
        alojamientos.setDireccion(alojamientoDto.getDireccion());
        alojamientos.setDescripcion(alojamientoDto.getDescripcion());


        //llamamos a las entidades relacionadas
        TamanioAlojamiento tamanioAlojamiento = tamanioAlojamientoRepository.findById(alojamientoDto.getTamanio()).get();
        alojamientos.setTamanioAlojamiento(tamanioAlojamiento);

        TipoAlojamiento tipoAlojamiento = tipoAlojamientoRepository.findById(alojamientoDto.getTipo()).get();
        alojamientos.setTipoAlojamiento(tipoAlojamiento);
        alojamientoService.guardar(alojamientos);


        return "redirect:/alojamientos/registro_alojamiento";
    }



    @GetMapping("/alojamientos/{id}/editar_alojamiento")
    public String editarAlojamiento(@PathVariable("id") Long id, Model interfazConPantalla) {
        // Obtener el alojamiento existente por su ID
        Optional<Alojamientos> alojamientoOptional = alojamientoService.getRepo().findById(id);
        if (alojamientoOptional.isPresent()) {
            Alojamientos alojamiento = alojamientoOptional.get();

            // Asignar los valores del alojamiento existente al objeto DTO
            AlojamientosDto alojamientoDto = new AlojamientosDto();
            alojamientoDto.setId(alojamiento.getId());
            alojamientoDto.setNombre(alojamiento.getNombre());
            alojamientoDto.setDireccion(alojamiento.getDireccion());
            alojamientoDto.setDescripcion(alojamiento.getDescripcion());
            alojamientoDto.setTamanio(alojamiento.getTamanioAlojamiento().getId());
            alojamientoDto.setTipo(alojamiento.getTipoAlojamiento().getId());

            List<TamanioAlojamiento> tamanioAlojamientoList = tamanioAlojamientoRepository.findAll();
            List<TipoAlojamiento> tipoAlojamientoList = tipoAlojamientoRepository.findAll();

            interfazConPantalla.addAttribute("datosAlojamiento", alojamientoDto);
            interfazConPantalla.addAttribute("listaTamaniosAlojamiento", tamanioAlojamientoList);
            interfazConPantalla.addAttribute("listaTipoAlojamiento", tipoAlojamientoList);

            return "alojamientos/editar_alojamiento";
        } else {
            // Manejar el caso en que el alojamiento no exista
            return "error"; // o redireccionar a alguna otra página o mostrar un mensaje de error
        }
    }




    @PostMapping("/alojamientos/{id}/editar_alojamiento")
    public String actualizarAlojamiento(@PathVariable("id") Long id, @ModelAttribute("datosAlojamiento") AlojamientosDto alojamientoDto) throws Exception {
        // Obtener el alojamiento existente por su ID
        Optional<Alojamientos> alojamientoOptional = alojamientoService.getRepo().findById(id);
        if (alojamientoOptional.isPresent()) {
            Alojamientos alojamiento = alojamientoOptional.get();

            alojamiento.setNombre(alojamientoDto.getNombre());
            alojamiento.setDireccion(alojamientoDto.getDireccion());
            alojamiento.setDescripcion(alojamientoDto.getDescripcion());

            // Llamamos a las entidades relacionadas
            TamanioAlojamiento tamanioAlojamiento = tamanioAlojamientoRepository.findById(alojamientoDto.getTamanio()).get();
            alojamiento.setTamanioAlojamiento(tamanioAlojamiento);

            TipoAlojamiento tipoAlojamiento = tipoAlojamientoRepository.findById(alojamientoDto.getTipo()).get();
            alojamiento.setTipoAlojamiento(tipoAlojamiento);

            alojamientoService.actualizarAlojamiento(alojamiento.getId(),alojamiento);

            return "redirect:/alojamientos/Listaalojamientos";
        } else {
            // Manejar el caso en que el alojamiento no exista
            return "error"; // o redireccionar a alguna otra página o mostrar un mensaje de error
        }
    }




    @PostMapping("/{id}/eliminar")
    public String eliminarAlojamiento(@PathVariable("id") Long id) {
        alojamientoService.eliminarAlojamiento(id);
        return "redirect:/alojamientos";
    }



}
