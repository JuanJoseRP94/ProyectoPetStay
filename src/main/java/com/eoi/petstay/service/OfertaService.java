package com.eoi.petstay.service;

import com.eoi.petstay.model.Oferta;
import com.eoi.petstay.repository.OfertaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertaService extends AbstractBusinessServiceSoloEnt<Oferta,Long,
        OfertaRepository> {
    //Acceso a los datos de la bbdd
    public OfertaService(OfertaRepository repo) {
        super(repo);
    }
    public  List<Oferta> obtenerTodos() {
        return getRepo().findAll();

    }

    public void crearOferta(Oferta oferta) {
    }
}
