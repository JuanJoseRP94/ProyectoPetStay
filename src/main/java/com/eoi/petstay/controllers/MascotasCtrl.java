package com.eoi.petstay.controllers;

import com.eoi.petstay.config.ConfigProperties;
import com.eoi.petstay.dto.MascotaDto;
import com.eoi.petstay.dto.MascotasDto;
import com.eoi.petstay.model.Mascotas;
import com.eoi.petstay.service.ifxMascotasSrvc;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
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

    @GetMapping("/lista")
    public String listar(Model modelo) {
        List<Mascotas> listaMascotas = mascotasSrvc.listarMascotas(1,5);
        List<MascotaDto> listaMascotasDto = listaMascotas.stream().map(this::toDto).toList();

        modelo.addAttribute("mascotas", listaMascotasDto);
        return "mascotas/listaMascotas";
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
        mascotaDto.setEspecie(mascota.getEspecie().getNombreEspecie());
        mascotaDto.setSexo(mascota.getSexo().getDescripcion());
        mascotaDto.setTamanio(mascota.getTamanio().getNombreTamanio());
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
}