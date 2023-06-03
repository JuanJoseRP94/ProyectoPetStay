package com.eoi.petstay.service;


import com.eoi.petstay.model.Usuarios;

public interface IUsuarioServicio {
    public String getEncodedPassword(Usuarios usuarios);
}
