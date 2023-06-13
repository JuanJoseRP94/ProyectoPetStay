package com.eoi.petstay.service;

import com.eoi.petstay.model.TipoCuidados;
import com.eoi.petstay.repository.TipoCuidadosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoCuidadosService extends AbstractBusinessServiceSoloEnt<TipoCuidados,Long,
        TipoCuidadosRepository>   {
    //Acceso a los datos de la bbdd
    public TipoCuidadosService(TipoCuidadosRepository repo) {
        super(repo);
    }
    public List<TipoCuidados> obtenerTodos() {
        return getRepo().findAll();

    }
}
