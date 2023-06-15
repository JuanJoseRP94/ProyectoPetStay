package com.eoi.petstay.controllers;

import com.eoi.petstay.dto.MascotasDto;
import com.eoi.petstay.model.*;
import com.eoi.petstay.repository.*;
import com.eoi.petstay.service.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AppMascotasController {
    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private EspecieRepository especieRepository;
    @Autowired
    private SexoRepository sexoRepository;
    @Autowired
    private ComportamientoRepository comportamientoRepository;
    @Autowired
    private TipoCuidadosRepository tipoCuidadosRepository;
    @Autowired
    private TamaniosRepository tamaniosRepository;

    public AppMascotasController(MascotaService mascotaService) {
        super();
        this.mascotaService = mascotaService;
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
        Page<Mascotas> mascotasPage = mascotaService.buscarTodos(pageable);

        model.addAttribute("mascotas", mascotasPage);

        int totalPages = mascotasPage.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "mascotas/Lista_Mascotas";
    }
    @GetMapping("/mascotas/{id}")
    public String editar(@PathVariable Long id, Model model){
        Optional<Mascotas> mascotas = mascotaService.encuentraPorId(id);
        model.addAttribute("mascotas", mascotas.get());
        return "mascotas/registro_mascota";
    }

    //Para dar de alta mascotas
    @GetMapping("/mascotas/registro_mascota")
    public String registroMascota(Model interfazConPantalla){
        //Instancia en memoria del dto a informar en la pantalla
        final MascotasDto mascotadto = new MascotasDto();
        // Creamos los listados para alimentar la pagina de alta
        List<Sexo> sexoList = sexoRepository.findAll();
        List<Especie> especieList = especieRepository.findAll();
        List<Comportamientos> comportamientosList = comportamientoRepository.findAll();
        List<TipoCuidados> tipoCuidadosList = tipoCuidadosRepository.findAll();
        List<Tamanios> tamaniosList = tamaniosRepository.findAll();

        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datosMascota", mascotadto);
        interfazConPantalla.addAttribute("listaSexo",sexoList);
        interfazConPantalla.addAttribute("listaEspecies",especieList);
        interfazConPantalla.addAttribute("listaTamanios",tamaniosList);
        interfazConPantalla.addAttribute("listaTipoCuidados",tipoCuidadosList);
        interfazConPantalla.addAttribute("listaComportamientos",comportamientosList);

        return "mascotas/registro_mascota";
    }


    @PostMapping("/mascotas/registro_mascota")
    public String guardarMascota( @ModelAttribute(name ="datosMascota") MascotasDto mascotasDto) throws Exception {
        // Tenemos que obtener el objeto de usuario
        Mascotas mascotas = new Mascotas();
        //Voy a copiar todos los campos
        mascotas.setNombreMascota(mascotasDto.getNombre());
        mascotas.setEdad(mascotasDto.getEdad());
        //Por cada id buscamos con el repositorio la entidad
        Especie especie = especieRepository.findById(mascotasDto.getEspecieId()).get();
        mascotas.setEspecie(especie);
        Sexo sexo = sexoRepository.findById(mascotasDto.getSexoId()).get();
        mascotas.setSexo(sexo);
        Tamanios tamanios = tamaniosRepository.findById(mascotasDto.getTamanioId()).get();
        mascotas.setTamanio(tamanios);


        /*Comportamientos comportamientos = comportamientoRepository.findById(mascotasDto.getComportamientos()).get();
        mascotas.setComportamientos((Set<Comportamientos>) comportamientos);
        TipoCuidados tipoCuidados = tipoCuidadosRepository.findById(mascotasDto.getTipocuidados()).get();
        mascotas.setTipoCuidados((Set<TipoCuidados>) tipoCuidados);*/

        mascotas.setComportamientos(mascotasDto.getComportamientos());
        mascotas.setTipoCuidados(mascotasDto.getTipocuidados());

        //Guardamos mascota
        mascotaService.guardar(mascotas);
        return "mascotas/Lista_Mascotas";
    }
}


