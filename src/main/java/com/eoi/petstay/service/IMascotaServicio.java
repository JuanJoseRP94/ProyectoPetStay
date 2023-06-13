package com.eoi.petstay.service;


import com.eoi.petstay.model.Mascotas;
import com.eoi.petstay.model.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IMascotaServicio {
    public String getEncodedPassword(Usuarios usuarios);

    List<Mascotas> findAll();

    Page<Mascotas> findAll(Pageable pageable);

    Optional<Mascotas> listarId(Long id);
}
