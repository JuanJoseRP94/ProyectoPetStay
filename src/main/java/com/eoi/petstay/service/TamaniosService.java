package com.eoi.petstay.service;


import com.eoi.petstay.model.Tamanios;
import com.eoi.petstay.repository.TamaniosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TamaniosService extends AbstractBusinessServiceSoloEnt<Tamanios,Long,
        TamaniosRepository>   {
    //Acceso a los datos de la bbdd
    public TamaniosService(TamaniosRepository repo) {
        super(repo);
    }
    public List<Tamanios> obtenerTodos() {
        return getRepo().findAll();

    }
}
