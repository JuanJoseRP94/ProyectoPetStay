package com.eoi.petstay.service;


import com.eoi.petstay.model.Usuario;
import com.eoi.petstay.repository.UsuarioRepository;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService extends AbstractBusinessServiceSoloEnt<Usuario,Long,
        UsuarioRepository>   {


    //
    //Acceso a los datos de la bbdd
    public UsuarioService(UsuarioRepository repo) {
        super(repo);
    }

    @Override
    public Resource leerImg(String nombre) {
        return null;
    }

    public  List<Usuario> obtenerTodos() {
        return getRepo().findAll();

    }

    public Optional<Usuario> buscarporemail(String email){
        Optional<Usuario> usuario = getRepo().findUsuarioByEmailAndActiveTrue(email);
        return  usuario;
    }
}
