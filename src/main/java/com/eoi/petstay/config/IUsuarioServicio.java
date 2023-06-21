package com.eoi.petstay.config;


import com.eoi.petstay.model.Mascotas;
import com.eoi.petstay.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsuarioServicio {
    public String getEncodedPassword(Usuario usuario);

    List<Usuario> findAll();

    Page<Mascotas> findAll(Pageable pageable);
}

