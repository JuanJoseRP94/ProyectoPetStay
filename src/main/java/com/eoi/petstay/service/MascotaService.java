package com.eoi.petstay.service;


import com.eoi.petstay.model.Mascotas;
import com.eoi.petstay.repository.MascotasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService extends AbstractBusinessServiceSoloEnt<Mascotas,Long,
        MascotasRepository> {
    //Acceso a los datos de la bbdd
    public MascotaService(MascotasRepository repo) {
        super(repo);
    }
    public  List<Mascotas> obtenerTodos() {
        return getRepo().findAll();

    }
}
