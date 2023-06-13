package com.eoi.petstay.controllers;

import com.eoi.petstay.model.Especie;
import com.eoi.petstay.model.Mascotas;
import com.eoi.petstay.repository.EspecieRepository;
import com.eoi.petstay.service.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AppMascotasController {
    @Autowired
    private MascotaService mascotaService;
    private final EspecieService especieService;
    private final TamaniosService tamaniosService;
    private final TipoCuidadosService tipoCuidadosService;


    @Autowired
    private EspecieRepository especieRepository;

    public AppMascotasController(MascotaService mascotaService, EspecieService especieService, TamaniosService tamaniosService, TipoCuidadosService tipoCuidadosService) {
        super();
        this.mascotaService = mascotaService;
        this.especieService = especieService;
        this.tamaniosService = tamaniosService;
        this.tipoCuidadosService = tipoCuidadosService;
    }


    @GetMapping("/mascotas/Perfil_Mascota")
    public String perfilMascota( ){
        return "mascotas/Perfil_Mascota";
    }

    //Listas y paginar los usuarios

    @GetMapping("/mascotas/Lista_Mascotas")
    public String getAllPaginated(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @NotNull Model model) {

        Pageable pageable = PageRequest.of(page-1, size);
        Page<Mascotas> mascotasPage = mascotaService.getRepo().findAll(pageable);

        model.addAttribute("mascotas", mascotasPage);

        int totalPages = mascotasPage.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "mascotas/lista";
    }
    @GetMapping("/mascotas/{id}")
    public String editar(@PathVariable Long id, Model model){
        Optional<Mascotas> mascotas = mascotaService.encuentraPorId(id);
        model.addAttribute("mascotas", mascotas);
        return "mascotas/detalles_mascotas";
    }

    //Para dar de alta mascotas
    @GetMapping("/mascotas/registro_mascota")
    public String registroMascota(Model interfazConPantalla){
        //Instancia en memoria del dto a informar en la pantalla
        final Mascotas mascota = new Mascotas();

        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datosMascota", mascota);
        System.out.println("Preparando registro de mascota");
        return "mascota/registro_mascota";
    }

    @PostMapping("/mascotas/registro_mascota")
    public String guardarMascota( @ModelAttribute(name ="datosMascota") Mascotas mascotas) throws Exception {
        // Tenemos que obtener el objeto de usuario

        //Guardamos mascota
        mascotaService.guardar(mascotas);
        return "mascota/Lista_Mascotas";

    }
}


