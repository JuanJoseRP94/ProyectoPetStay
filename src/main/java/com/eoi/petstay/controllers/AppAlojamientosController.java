package com.eoi.petstay.controllers;

import com.eoi.petstay.config.ConfigProperties;
import com.eoi.petstay.dto.AlojamientosDto;
import com.eoi.petstay.dto.MascotaDto;
import com.eoi.petstay.model.*;
import com.eoi.petstay.repository.AlojamientoRepository;
import com.eoi.petstay.repository.TamanioAlojamientoRepository;
import com.eoi.petstay.repository.TipoAlojamientoRepository;
import com.eoi.petstay.service.UsuarioService;
import com.eoi.petstay.util.FileUploadUtil;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import com.eoi.petstay.service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AppAlojamientosController {
    @Autowired
    ConfigProperties configProperties;
    @Autowired
    private final AlojamientoService alojamientoService;

    private final ModelMapper modelMapper;

    @Autowired
    private final TipoAlojamientoRepository tipoAlojamientoRepository;
    @Autowired
    private final TamanioAlojamientoRepository tamanioAlojamientoRepository;

    @Autowired
    private final UsuarioService usuarioService;

    public AppAlojamientosController(AlojamientoService alojamientoService, AlojamientoRepository alojamientoRepository, ModelMapper modelMapper, TipoAlojamientoRepository tipoAlojamientoRepository, TamanioAlojamientoRepository tamanioAlojamientoRepository, UsuarioService usuarioService) {
        super();
        this.alojamientoService = alojamientoService;
        this.modelMapper = modelMapper;
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

        return "/alojamientos/Lista_Alojamientos";
    }



    @GetMapping("/alojamientos/registro_alojamiento")
    public String registroAlojamiento(Model interfazConPantalla) {

        // Instancia en memoria del objeto a informar en la pantalla
        AlojamientosDto alojamientoDto = new AlojamientosDto();
        alojamientoDto.setUsuario(1L);  // poner el id del usuario que está en la sesión (se obtiene del objeto Principal de Spring security)

        List<TamanioAlojamiento> tamanioAlojamientoList = tamanioAlojamientoRepository.findAll();
        List<TipoAlojamiento> tipoAlojamientoList = tipoAlojamientoRepository.findAll();
        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("titulo","Ficha alojamiento");
        interfazConPantalla.addAttribute("usuario", "1"); //TODO debe ser el usuario que está en la sesión
        interfazConPantalla.addAttribute("datosAlojamiento", alojamientoDto);
        interfazConPantalla.addAttribute("listaTipoAlojamiento", tipoAlojamientoList);
        interfazConPantalla.addAttribute("listaTamaniosAlojamiento", tamanioAlojamientoList);




        return "/alojamientos/registro_alojamiento";
    }



    @PostMapping("/alojamientos/registro_alojamiento")
    public String guardarAlojamiento(@ModelAttribute("datosAlojamiento") AlojamientosDto alojamientoDto , @RequestParam("img") MultipartFile imagen,
                                     ModelMap interfazConPantalla) throws Exception {

        Alojamientos alojamientos = new Alojamientos();
        // ... Grabamos el archivo en la carpeta de imágenes. El nombre de la carpeta se obtiene del archivo
        //     application.properties via clase ConfigProperties
        String imgDir = "./" + configProperties.getRuta();
        FileUploadUtil.saveFile(imgDir, imagen.getOriginalFilename(), imagen);



        //llamamos a las entidades relacionadas
        TamanioAlojamiento tamanioAlojamiento = tamanioAlojamientoRepository.findById(alojamientoDto.getTamanio()).get();
        alojamientos.setTamanioAlojamiento(tamanioAlojamiento);

        TipoAlojamiento tipoAlojamiento = tipoAlojamientoRepository.findById(alojamientoDto.getTipo()).get();
        alojamientos.setTipoAlojamiento(tipoAlojamiento);

        // ... guardamos la entidad en la BBDD
        alojamientoService.guardarAlojamiento(alojamientos);

        return "redirect:/alojamientos/Listaalojamientos";
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

            //Obtengo la ruta en la que están las imágenes a partir de la configuración
            // OJO Añado "../" en la ruta porque la carpeta está en el raiz del proyecto
            String url = UriComponentsBuilder.newInstance()
                    .scheme(configProperties.getProtocolo())
                    .host(configProperties.getServidor())
                    .port(configProperties.getPuerto())
                    .path("../" + configProperties.getRuta() + "/" + alojamiento.getFoto())
                    .build().toString();
            alojamientoDto.setFotoConRuta(url);

            interfazConPantalla.addAttribute("datosAlojamiento", alojamientoDto);
            interfazConPantalla.addAttribute("listaTamaniosAlojamiento", tamanioAlojamientoList);
            interfazConPantalla.addAttribute("listaTipoAlojamiento", tipoAlojamientoList);

            return "/alojamientos/editar_alojamiento";
        } else {
            // Manejar el caso en que el alojamiento no exista
            return "error"; // o redireccionar a alguna otra página o mostrar un mensaje de error
        }
    }

    @PostMapping("/alojamientos/{id}/editar_alojamiento")
    public String actualizarAlojamiento(@PathVariable("id") Long id, @ModelAttribute("datosAlojamiento") AlojamientosDto alojamientoDto,
                                        @RequestParam("img") MultipartFile imagen) throws Exception {
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

            // ... guardamos la entidad en la BBDD
            alojamientoService.guardarAlojamiento(alojamiento);

            return "redirect:/alojamientos/Listaalojamientos";
        } else {
            // Manejar el caso en que el alojamiento no exista
            return "error"; // o redireccionar a alguna otra página o mostrar un mensaje de error
        }
    }





    @PostMapping("/alojamientos/{id}")
    public String eliminarAlojamiento(@PathVariable("id") Long id) {
        alojamientoService.eliminarAlojamiento(id);
        return "redirect:/alojamientos/Listaalojamientos";
    }

    @GetMapping("/imagenes/{nombre:.+}")
    public ResponseEntity<Resource> leerImagen(@PathVariable String nombre) {
        Resource archivo = alojamientoService.leerImg(nombre);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + archivo.getFilename() + "\"").body(archivo);
    }



    private AlojamientosDto toDto(Alojamientos alojamientos){
        //TODO Esto debería hacerse con un mapper
        AlojamientosDto alojamientosDto = new AlojamientosDto();
        AlojamientosDto..setId(alojamientos.getId());
        AlojamientosDto.(alojamientos.getNombre());
        AlojamientosDto.set(mascota.getEspecie().getId());
        mascotaDto.setSexo(mascota.getSexo().getId());
        mascotaDto.setTamanio(mascota.getTamanio().getId());
        mascotaDto.setValoracion(mascota.getValoracion());
        mascotaDto.setUsuario(mascota.getUsuario().getId());
        //Obtengo la ruta en la que están las imágenes a partir de la configuración
        // OJO Añado "../" en la ruta porque la carpeta está en el raiz del proyecto
        String url = UriComponentsBuilder.newInstance()
                .scheme(configProperties.getProtocolo())
                .host(configProperties.getServidor())
                .port(configProperties.getPuerto())
                .path("../" + configProperties.getRuta() + "/" + mascota.getFoto())
                .build().toString();
        mascotaDto.setFotoConRuta(url);

        return mascotaDto;
    }

    private Mascotas toEntidad(MascotaDto mascotaDto){
        Mascotas nueva = new Mascotas();
        nueva.setNombre(mascotaDto.getNombre());
        nueva.setEdad(mascotaDto.getEdad());
        nueva.setValoracion(mascotaDto.getValoracion());
        nueva.setFoto(mascotaDto.getFotoConRuta());
        // Ejemplo de uso del optional en una sentencia de programación funciona
        usuarioRepo.findById(mascotaDto.getUsuario()).ifPresent(nueva::setUsuario);
        especieRepository.findById(mascotaDto.getEspecie()).ifPresent(nueva::setEspecie);
        sexoRepository.findById(mascotaDto.getSexo()).ifPresent(nueva::setSexo);
        tamaniosRepository.findById(mascotaDto.getTamanio()).ifPresent(nueva::setTamanio);
        return nueva;
    }

}
