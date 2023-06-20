package com.eoi.petstay.controllers;

import com.eoi.petstay.config.ConfigProperties;
import com.eoi.petstay.dto.MascotaDto;
import com.eoi.petstay.dto.MascotasDto;
import com.eoi.petstay.model.*;
import com.eoi.petstay.repository.*;
import com.eoi.petstay.service.ifxMascotasSrvc;
import com.eoi.petstay.util.FileUploadUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.print.DocFlavor;
import java.util.List;

@Controller
@RequestMapping("/mascotasv2")
public class MascotasCtrl {
    // Conectamos con el servicio de mascotas
    @Autowired
    private ifxMascotasSrvc mascotasSrvc;
    // Conectamos con la configuración de parámetros
    @Autowired
    private ConfigProperties configProperties;
    // Conectamos con las otras entidades
    //TODO deberían ser interfaces de servicios
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
    private UsuarioRepository usuarioRepo;

    private int borrado = 0;
    private Exception exception;

    @GetMapping("/lista")
    public String listar(Model modelo, RedirectAttributes redirectAttributes) {
        List<Mascotas> listaMascotas = mascotasSrvc.listarMascotas(0,5);
        List<MascotaDto> listaMascotasDto = listaMascotas.stream().map(this::toDto).toList();
        switch (borrado) {
            case 1:
                modelo.addAttribute("msg", "Registro borrado");
                break;
            case -1:
                modelo.addAttribute("msg","No se puede borrar el registro. Error: " + exception.getMessage());
                break;
        }
        borrado = 0;
        modelo.addAttribute("mascotas", listaMascotasDto);
        return "mascotas/listaMascotas";
    }

    @GetMapping("/nueva")
    public String nueva(Model modelo){
        // Instanciamos una nueva mascota para acoger los datos
        MascotasDto nueva = new MascotasDto();
        nueva.setUsuario(1L);  // poner el id del usuario que está en la sesión (se obtiene del objeto Principal de Spring security)
        // Creamos los listados para alimentar la página de alta
        List<Sexo> sexoList = sexoRepository.findAll(); //TODO ¿convertir a ENUM?
        List<Especie> especieList = especieRepository.findAll();
        List<Comportamientos> comportamientosList = comportamientoRepository.findAll();
        List<TipoCuidados> tipoCuidadosList = tipoCuidadosRepository.findAll();
        List<Tamanios> tamaniosList = tamaniosRepository.findAll();
        //Mediante "addAttribute" comparto con la pantalla
        modelo.addAttribute("titulo","Ficha mascota");
        modelo.addAttribute("usuario", "1"); //TODO debe ser el usuario que está en la sesión
        modelo.addAttribute("datosMascota", nueva);
        modelo.addAttribute("listaSexo",sexoList);
        modelo.addAttribute("listaEspecies",especieList);
        modelo.addAttribute("listaTamanios",tamaniosList);
        modelo.addAttribute("listaTipoCuidados",tipoCuidadosList);
        modelo.addAttribute("listaComportamientos",comportamientosList);

        return "mascotas/fichaMascota";
    }

    @PostMapping("/nueva")
    public String nuevaMascota(@ModelAttribute(name ="datosMascota") MascotaDto mascotaDto, @RequestParam("img") MultipartFile imagen,
                               ModelMap modelo) throws Exception {
        // Convertimos los datos recibidos a un objeto de clase Mascotas
        Mascotas nuevaMascota = toEntidad(mascotaDto);
        // ... Grabamos el archivo en la carpeta de imágenes. El nombre de la carpeta se obtiene del archivo
        //     application.properties via clase ConfigProperties
        String imgDir = "./" + configProperties.getRuta();
        FileUploadUtil.saveFile(imgDir, imagen.getOriginalFilename(), imagen);
        // ... guardamos la entidad en la BBDD
        mascotasSrvc.grabaMascota(nuevaMascota);

        return "redirect:/mascotasv2/lista";
    }

    @GetMapping("/delete/{id}")
    public String borrarMascota(@PathVariable Long id, Model modelo, RedirectAttributes redirectAttributes) {
        try {
            // TODO borro la imagen dela carpeta de imágenes

            // Borro de la BBDD
            mascotasSrvc.borrarMascota(id);
            borrado = 1;
        } catch (Exception e) {
            borrado = -1;
            exception = e;
        }

        return "redirect:/mascotasv2/lista";
    }

    // Obtenemos la imagen
    @GetMapping("/imagenes/{nombre:.+}")
    public ResponseEntity<Resource> leerImagen(@PathVariable String nombre) {
        Resource archivo = mascotasSrvc.leerImg(nombre);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + archivo.getFilename() + "\"").body(archivo);
    }

    private MascotaDto toDto(Mascotas mascota){
        //TODO Esto debería hacerse con un mapper
        MascotaDto mascotaDto = new MascotaDto();
        mascotaDto.setId(mascota.getId());
        mascotaDto.setNombre(mascota.getNombre());
        mascotaDto.setEdad(mascota.getEdad());
        mascotaDto.setEspecie(mascota.getEspecie().getId());
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