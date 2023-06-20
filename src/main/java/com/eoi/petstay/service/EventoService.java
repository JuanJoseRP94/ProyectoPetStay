package com.eoi.petstay.service;


import com.eoi.petstay.model.Evento;

import com.eoi.petstay.repository.EspecieRepository;
import com.eoi.petstay.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public void guardarEvento(Evento evento) {
        // Implementa la lógica para guardar el evento en la base de datos utilizando el repositorio
        eventoRepository.save(evento);
    }
}