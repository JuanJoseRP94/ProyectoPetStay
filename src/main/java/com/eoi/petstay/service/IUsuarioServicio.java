package com.eoi.petstay.service;


import com.eoi.petstay.model.Usuario;

public interface IUsuarioServicio {
    public String getEncodedPassword(Usuario usuario);
}
