package com.eoi.petstay.controllers;

import com.eoi.petstay.dto.EventoDto;import com.eoi.petstay.model.*;
import com.eoi.petstay.repository.*;
import com.eoi.petstay.service.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AppEventosController {
        @Autowired
        private EventoService eventoService;

        @GetMapping("/reservas/detalle_reserva")
        public String mostrarFormularioEvento(Model model) {
                Evento evento = new Evento();
                model.addAttribute("evento", evento);
                return "/reservas/detalle_reserva";
        }

        @PostMapping("/reservas/detalle_reserva")
        public String guardarEvento(@Validated @ModelAttribute("evento") Evento evento, BindingResult bindingResult) {
                if (bindingResult.hasErrors()) {
                        return "/reservas/detalle_reserva";
                }

                eventoService.guardarEvento(evento);
                return "/reservas/Pagos";
        }
}