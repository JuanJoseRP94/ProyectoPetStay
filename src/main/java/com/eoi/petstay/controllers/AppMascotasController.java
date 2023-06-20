package com.eoi.petstay.controllers;

import com.eoi.petstay.config.ConfigProperties;
import com.eoi.petstay.dto.MascotasDto;
import com.eoi.petstay.model.*;
import com.eoi.petstay.repository.*;
import com.eoi.petstay.service.*;
import com.eoi.petstay.util.FileUploadUtil;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AppMascotasController {
    @Autowired
    ConfigProperties configProperties;
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
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("/mascotas/Perfil_Mascotas")
    public String perfilMascota( ){
        return "mascotas/Perfil_Mascotas";
    }

    //Listas y paginar los usuarios

    @GetMapping("/mascotas/listamascotas")
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


    //Para dar de alta mascotas
    @GetMapping("/mascotas/registromascota")
    public String registroMascota(Model interfazConPantalla){
        //Leemos el directorio
        System.out.println("Path:" +   configProperties.getRuta());
        //Instancia en memoria del dto a informar en la pantalla
        final MascotasDto mascotadto = new MascotasDto();
        // Creamos los listados para alimentar la página de alta
        List<Sexo> sexoList = sexoRepository.findAll();
        List<Especie> especieList = especieRepository.findAll();
        List<Comportamientos> comportamientosList = comportamientoRepository.findAll();
        List<TipoCuidados> tipoCuidadosList = tipoCuidadosRepository.findAll();
        List<Tamanios> tamaniosList = tamaniosRepository.findAll();
        //Temporalmente listamos imágenes de static
        File ruta = new File("/img/animales");
        List<String> imagenes = listarArchivos(ruta,".jpg");


        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datosMascotas", mascotadto);
        interfazConPantalla.addAttribute("listaSexo",sexoList);
        interfazConPantalla.addAttribute("listanimales",imagenes);
        interfazConPantalla.addAttribute("listaEspecies",especieList);
        interfazConPantalla.addAttribute("listaTamanios",tamaniosList);
        interfazConPantalla.addAttribute("listaTipoCuidados",tipoCuidadosList);
        interfazConPantalla.addAttribute("listaComportamientos",comportamientosList);

        return "mascotas/registromascotas";
    }

    @PostMapping("/mascotas/registromascota")
    public String guardarMascota( @ModelAttribute(name ="datosMascotas") MascotasDto mascotasDto, @RequestParam("foto") MultipartFile imagen) throws Exception {
        //Leemos el directorio
        System.out.println("Path:" +   configProperties.getRuta());
        // Tenemos que obtener el objeto de usuario
        Mascotas mascotas = new Mascotas();
        //Voy a copiar todos los campos
        mascotas.setNombre(mascotasDto.getNombre());
        mascotas.setEdad(mascotasDto.getEdad());
        //Por cada id buscamos con el repositorio la entidad
        Especie especie = especieRepository.findById(mascotasDto.getEspecie()).get();
        mascotas.setEspecie(especie);
        Sexo sexo = sexoRepository.findById(mascotasDto.getSexo()).get();
        mascotas.setSexo(sexo);
        Tamanios tamanios = tamaniosRepository.findById(mascotasDto.getTamanio()).get();
        mascotas.setTamanio(tamanios);
        mascotas.setComportamientos(mascotasDto.getComportamientos());
        mascotas.setTipoCuidados(mascotasDto.getTipoCuidados());
        // Procesamos la foto ...
        // ... Generamos el nombre del archivo
        // ATENCION. Para evitar nombre duplicados, deberíamos añadir el id del usuario de la mascota o componer
        // el nombre de forma que nos aseguremos que es único cuando se guarde en la carpeta de imágenes
        String nombreArch = StringUtils.cleanPath(imagen.getOriginalFilename());
        // ... asignamos el nombre en la entidad
        mascotas.setFoto(nombreArch);
        // ... guardamos la entidad en la BBDD
        Mascotas nuevaMascota = mascotaService.guardar(mascotas);
        // ... grabamos el archivo en la carpeta de imágenes. El nombre de la carpeta se obtiene del archivo
        //     application.properies via clase ConfigProperties
        String imgDir = configProperties.getRuta();
        FileUploadUtil.saveFile(imgDir, nombreArch, imagen);

        //Guardamos mascota
        return "redirect:/mascotas/listamascotas";
    }

    private static final String UPLOAD_DIRECTORY = "/imagenes";



    private  List<String> listarArchivos(File ruta, String tipo) {
        List<String> imagenes = new ArrayList<>();
        //la ruta es la que tiene las imagenes
        // Creo el vector que contendra todos los archivos de una ruta especificada
        File[] archivo = ruta.listFiles();
        //Evaluo si la carpeta especificada contiene archivos.
        if (archivo != null) {
            //Recorro el vector el cual tiene almacenado la ruta del archivo a buscar.
            for (int i = 0; i < archivo.length; i++) {
                File Arc = archivo[i];
                //Evaluo el tipo de extencion.
                if (archivo[i].getName().endsWith("tipo")) {
                    imagenes.add(archivo[i].getName());
                }
            }
        }
        return imagenes;
    }

    //Para editar mascotas
    @GetMapping("/mascotas/{id}")
    public String editarMascotaGet(@PathVariable("id") Long id,Model interfazConPantalla){
        //Valores para listas
        // Creamos los listados para alimentar la pagina de alta
        List<Sexo> sexoList = sexoRepository.findAll();
        List<Especie> especieList = especieRepository.findAll();
        List<Comportamientos> comportamientosList = comportamientoRepository.findAll();
        List<TipoCuidados> tipoCuidadosList = tipoCuidadosRepository.findAll();
        List<Tamanios> tamaniosList = tamaniosRepository.findAll();
        //Instancia en memoria del dto a informar en la pantalla
        final MascotasDto mascotadto = new MascotasDto();
        Optional<Mascotas> mascota  = mascotaService.encuentraPorId(id);
        if (mascota.isPresent()){
            //Informamos el dto

            //Mediante "addAttribute" comparto con la pantalla
            interfazConPantalla.addAttribute("datosMascotas", mascotadto);
            interfazConPantalla.addAttribute("listaSexo",sexoList);
            interfazConPantalla.addAttribute("listaEspecies",especieList);
            interfazConPantalla.addAttribute("listaTamanios",tamaniosList);
            interfazConPantalla.addAttribute("listaTipoCuidados",tipoCuidadosList);
            interfazConPantalla.addAttribute("listaComportamientos",comportamientosList);
            return "mascotas/detalles_mascota";
        } else{
            //Mostrar página usuario no existe
            return "mascotas/detallesmascotanoencontrados";
        }
    }

    @PostMapping("/mascotas/{id}")
    public String editarMascota( @PathVariable("idusr") Long id,@ModelAttribute(name ="datosMascotas") MascotasDto mascotasDto /*, @RequestParam("foto") MultipartFile foto*/) throws Exception {
        // Tenemos que obtener el objeto de usuario
        Mascotas mascotas = new Mascotas();
        //Voy a copiar todos los campos
        mascotas.setId(mascotasDto.getId());
        // mascotas.setFoto(mascotasDto.getFoto());
        mascotas.setNombre(mascotasDto.getNombre());
        mascotas.setEdad(mascotasDto.getEdad());
        //Por cada id buscamos con el repositorio la entidad
        Especie especie = especieRepository.findById(mascotasDto.getEspecie()).get();
        mascotas.setEspecie(especie);
        Sexo sexo = sexoRepository.findById(mascotasDto.getSexo()).get();
        mascotas.setSexo(sexo);
        Tamanios tamanios = tamaniosRepository.findById(mascotasDto.getTamanio()).get();
        mascotas.setTamanio(tamanios);
        mascotas.setComportamientos(mascotasDto.getComportamientos());
        mascotas.setTipoCuidados(mascotasDto.getTipoCuidados());

        //Guardamos mascota
        mascotaService.guardar(mascotas);
        return "redirect:/mascotas/listamascotas";
    }
}


