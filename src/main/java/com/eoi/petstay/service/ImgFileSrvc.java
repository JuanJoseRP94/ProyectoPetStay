package com.eoi.petstay.service;

import com.eoi.petstay.model.Imagen;
import com.eoi.petstay.repository.FileSystemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.eoi.petstay.repository.ImagenRepo;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class ImgFileSrvc {
    /*
        Este servicio utiliza FileSystemRepo para acceder a grabar y buscar archivos de imágenes
        y imgRepo para actualizar el nombre y la ubicación (uri) en la BBDD.
     */
    @Autowired
    private FileSystemRepo fsRepo;

    @Autowired
    private ImagenRepo imgRepo;

    public Long grabar(byte[] bytes, String nombre) throws IOException {
        String uri = fsRepo.grabar(bytes, nombre);
        return imgRepo.save(new Imagen(nombre, uri)).getId();
    }

    public FileSystemResource buscar(Long imgId){
        Imagen img = imgRepo.findById(imgId)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
        return fsRepo.buscar(img.getUri());
    }
}
