package com.eoi.petstay.service;

import com.eoi.petstay.model.Alojamientos;
import com.eoi.petstay.repository.AlojamientoRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class AlojamientoService extends AbstractBusinessServiceSoloEnt<Alojamientos,Long,
        AlojamientoRepository> {

    // Ruta de la carpeta de imágenes
    private final Path root = Paths.get("./subidas/imagenes");


    public AlojamientoService(AlojamientoRepository repo, AlojamientoRepository alojamientoRepository) {
        super(repo);
        this.alojamientoRepository = alojamientoRepository;
    }
    public  List<Alojamientos> obtenerTodos() {
        return getRepo().findAll();
    }
    private final AlojamientoRepository alojamientoRepository;

    public List<Alojamientos> obtenerAlojamientos() {
        return alojamientoRepository.findAll();
    }

    public Optional<Alojamientos> obtenerAlojamientoPorId(Long id) {
        return alojamientoRepository.findById(id);
    }

    public Alojamientos guardarAlojamiento(Alojamientos alojamiento) {
        return alojamientoRepository.save(alojamiento);
    }

    public void actualizarAlojamiento(Long id, Alojamientos alojamientoActualizado) {
        Optional<Alojamientos> alojamiento = alojamientoRepository.findById(id);
        if (alojamiento.isPresent()) {
            alojamientoActualizado.setId(id);
            alojamientoRepository.save(alojamientoActualizado);
        }
    }

    public void eliminarAlojamiento(Long id) {
        alojamientoRepository.deleteById(id);
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
