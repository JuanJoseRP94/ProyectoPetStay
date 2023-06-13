package com.eoi.petstay.config;


import com.eoi.petstay.model.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUsuarioServicio {
    public String getEncodedPassword(Usuarios usuarios);
}
