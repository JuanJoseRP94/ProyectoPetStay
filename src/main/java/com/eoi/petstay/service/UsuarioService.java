package com.eoi.petstay.service;


import com.eoi.petstay.model.Usuarios;
import com.eoi.petstay.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends AbstractBusinessServiceSoloEnt<Usuarios,Long,
        UsuarioRepository>   {
    //
    //Acceso a los datos de la bbdd
    public UsuarioService(UsuarioRepository repo) {

        super(repo);
    }



}
