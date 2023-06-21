package com.eoi.petstay.service;

import com.eoi.petstay.model.Mascotas;
import com.eoi.petstay.repository.MascotasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class MascotasSrvc implements ifxMascotasSrvc{
    // Conectamos con el repositorio
    @Autowired
    private MascotasRepo mascotasRepo;

    // Ruta de la carpeta de imágenes
    private final Path root = Paths.get("./subidas/imagenes");

    @Override
    public List<Mascotas> listarMascotas(int pag, int items) {
        // Definimos los paramétros para la paginación
        PageRequest pageReq = PageRequest.of(pag, items);
        // Obtenemos los datos correspondientes
        Page<Mascotas> listaMascotas = mascotasRepo.findAll(pageReq);
        // Devolvemos la lista con los items en la página
        return listaMascotas.getContent();
    }

    @Override
    public Optional<Mascotas> cargarMascota(Long id) {
        return mascotasRepo.findById(id);
    }

    @Override
    public void modificarMascota(Mascotas mascota) {
    }

    @Override
    public Mascotas grabaMascota(Mascotas mascota) {
        return mascotasRepo.save(mascota);
    }

    @Override
    public void borrarMascota(Long id) {
        mascotasRepo.deleteById(id);
    }

    @Override
    public List<Mascotas> listarMascotasUsuario(Long idUsuario, int pag, int items) {
        // Definimos los parámetros para la paginación
        PageRequest pageReq = PageRequest.of(pag, items);
        // Obtenemos los datos correspondientes
        Page<Mascotas> listaMascotas = mascotasRepo.listaMascotasUsuario(idUsuario, pageReq);
        // Devolvemos la lista con los items en la página
        return listaMascotas.getContent();
    }

    @Override
    public Resource leerImg(String nombre) {
        /*
            Lee el archivo desde la carpeta indicada en la configuración
         */
        Path arch = root.resolve(nombre);
        try {
            Resource img = new UrlResource(arch.toUri());
            if (img.exists() || img.isReadable()) {
                return img;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
