package com.eoi.petstay.service;


import com.eoi.petstay.model.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsuarioServicio {
    public String getEncodedPassword(Usuarios usuarios);

    public List<Usuarios> findAll();

    public Page<Usuarios> findAll(Pageable pageable);
}
