package com.eoi.petstay.service;

import com.eoi.petstay.model.Mascotas;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Optional;

public interface ifxMascotasSrvc{
    //TODO Usar ordenación añadiendo "String dirOrden, String orden" (tenerlo en cuenta en la implementación
    List<Mascotas> listarMascotas(int pag, int items);
    Optional<Mascotas> cargarMascota(Long id);
    void modificarMascota(Mascotas mascota);
    Mascotas grabaMascota(Mascotas mascota);
    void borrarMascota(Long id);
    List<Mascotas> listarMascotasUsuario(Long idUsuario, int pag, int items);
    Resource leerImg(String nombre);
}
