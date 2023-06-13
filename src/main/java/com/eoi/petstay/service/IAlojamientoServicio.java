package com.eoi.petstay.service;

import com.eoi.petstay.model.Alojamientos;
import com.eoi.petstay.model.Mascotas;
import com.eoi.petstay.model.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAlojamientoServicio {
    public String getEncodedPassword(Usuarios usuarios);

    List<Alojamientos> findAll();

    Page<Alojamientos> findAll(Pageable pageable);

    Optional<Alojamientos> listarId(Long id);
}
