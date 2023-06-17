package com.eoi.petstay.service;

import com.eoi.petstay.dto.EventoDto;
import com.eoi.petstay.model.*;
import com.eoi.petstay.repository.*;
import com.eoi.petstay.service.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<EventoDto> obtenerTodosLosEventos() {
        List<Evento> eventos = eventoRepository.findAll();
        return convertirAEventoDto(eventos);
    }

    public EventoDto agregarEvento(EventoDto eventoDto) {
        Evento evento = convertirAEvento(eventoDto);
        Evento eventoGuardado = eventoRepository.save(evento);
        return convertirAEventoDto(eventoGuardado);
    }

    public void eliminarEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    public EventoDto editarEvento(Long id, EventoDto eventoDto) {
        Evento eventoExistente = eventoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Evento no encontrado con ID: " + id));

        eventoExistente.setTitulo(eventoDto.getTitulo());
        eventoExistente.setFechaInicio(eventoDto.getFechaInicio());
        eventoExistente.setFechaFin(eventoDto.getFechaFin());

        Evento eventoActualizado = eventoRepository.save(eventoExistente);
        return convertirAEventoDto(eventoActualizado);
    }

    private List<EventoDto> convertirAEventoDto(List<Evento> eventos) {
        return eventos.stream()
                .map(this::convertirAEventoDto)
                .collect(Collectors.toList());
    }

    private EventoDto convertirAEventoDto(Evento evento) {
        return new EventoDto(
                evento.getId(),
                evento.getTitulo(),
                evento.getFechaInicio(),
                evento.getFechaFin()
        );
    }

    private Evento convertirAEvento(EventoDto eventoDto) {
        return new Evento(
                eventoDto.getId(),
                eventoDto.getTitulo(),
                eventoDto.getFechaInicio(),
                eventoDto.getFechaFin()
        );
    }
}
