package com.eoi.petstay.service;


import com.eoi.petstay.model.Usuarios;
import com.eoi.petstay.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService extends AbstractBusinessServiceSoloEnt<Usuarios,Long,
        UsuarioRepository>   {
    private final UsuarioRepository repository;

    //
    //Acceso a los datos de la bbdd
    public UsuarioService(UsuarioRepository repo) {

        super(repo);
        this.repository = repo;
    }
    public static List<Usuarios> obtenerTodos() {
        return repository.findAll();
    }
}
