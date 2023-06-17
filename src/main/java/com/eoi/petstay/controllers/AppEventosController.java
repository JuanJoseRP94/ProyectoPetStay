package com.eoi.petstay.controllers;

import com.eoi.petstay.dto.EventoDto;import com.eoi.petstay.model.*;
import com.eoi.petstay.repository.*;
import com.eoi.petstay.service.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/calendario")
public class AppEventosController {
    private final EventoService eventoService;

    public AppEventosController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<EventoDto>> obtenerEventos() {
        List<EventoDto> eventos = eventoService.obtenerTodosLosEventos();
        return ResponseEntity.ok(eventos);
    }

    @PostMapping("/eventos")
    public ResponseEntity<EventoDto> agregarEvento(@RequestBody EventoDto eventoDto) {
        EventoDto nuevoEvento = eventoService.agregarEvento(eventoDto);
        return ResponseEntity.ok(nuevoEvento);
    }

    @DeleteMapping("/eventos/{id}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable Long id) {
        eventoService.eliminarEvento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/eventos/{id}")
    public ResponseEntity<EventoDto> editarEvento(@PathVariable Long id, @RequestBody EventoDto eventoDto) {
        EventoDto eventoActualizado = eventoService.editarEvento(id, eventoDto);
        return ResponseEntity.ok(eventoActualizado);
    }
}

