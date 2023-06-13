package com.eoi.petstay.service;


import com.eoi.petstay.model.Especie;

import com.eoi.petstay.repository.EspecieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecieService extends AbstractBusinessServiceSoloEnt<Especie,Long,
        EspecieRepository>   {
    //Acceso a los datos de la bbdd
    public EspecieService(EspecieRepository repo) {
        super(repo);
    }
    public List<Especie> obtenerTodos() {
        return getRepo().findAll();

    }
}
