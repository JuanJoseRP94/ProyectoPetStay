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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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


    @GetMapping("/mascotas/Perfil_Mascotas")
    public String perfilMascota( ){
        return "mascotas/Perfil_Mascotas";
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
        return "mascotas/registro_mascotas";
    }

    //Para dar de alta mascotas
    @GetMapping("/mascotas/registro_mascotas")
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
        interfazConPantalla.addAttribute("datosMascotas", mascotadto);
        interfazConPantalla.addAttribute("listaSexo",sexoList);
        interfazConPantalla.addAttribute("listaEspecies",especieList);
        interfazConPantalla.addAttribute("listaTamanios",tamaniosList);
        interfazConPantalla.addAttribute("listaTipoCuidados",tipoCuidadosList);
        interfazConPantalla.addAttribute("listaComportamientos",comportamientosList);

        return "mascotas/registro_mascotas";
    }

    @PostMapping("/mascotas/registro_mascotas")
    public String guardarMascota( @ModelAttribute(name ="datosMascotas") MascotasDto mascotasDto /*, @RequestParam("foto") MultipartFile foto*/) throws Exception {
        // Tenemos que obtener el objeto de usuario
        Mascotas mascotas = new Mascotas();
        //Voy a copiar todos los campos
        // mascotas.setFoto(mascotasDto.getFoto());
        mascotas.setNombreMascota(mascotasDto.getNombre());
        mascotas.setEdad(mascotasDto.getEdad());
        //Por cada id buscamos con el repositorio la entidad
        Especie especie = especieRepository.findById(mascotasDto.getEspecie()).get();
        mascotas.setEspecie(especie);
        Sexo sexo = sexoRepository.findById(mascotasDto.getSexo()).get();
        mascotas.setSexo(sexo);
        Tamanios tamanios = tamaniosRepository.findById(mascotasDto.getTamanio()).get();
        mascotas.setTamanio(tamanios);
        mascotas.setComportamientos(mascotasDto.getComportamientos());
        mascotas.setTipoCuidados(mascotasDto.getTipocuidados());
        /*if (!foto.isEmpty()) {
            try {
                String nombreArchivo = foto.getOriginalFilename();
                Path rutaArchivo = Paths.get(UPLOAD_DIRECTORY, nombreArchivo);
                Files.write(rutaArchivo, foto.getBytes());
                mascotas.setFoto(nombreArchivo); // Guardar la ruta del archivo en el objeto DatosMascota
            } catch (IOException e) {
                e.printStackTrace();
                // Manejar la excepción en caso de error al guardar la foto
            }
        }*/
        //Guardamos mascota
        mascotaService.guardar(mascotas);
        return "mascotas/Lista_Mascotas";
    }
    private static final String UPLOAD_DIRECTORY = "/imagenes";
}


