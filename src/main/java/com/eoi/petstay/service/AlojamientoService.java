package com.eoi.petstay.service;

import com.eoi.petstay.model.Alojamientos;
import com.eoi.petstay.repository.AlojamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlojamientoService {
    private final AlojamientoRepository alojamientoRepository;

    @Autowired
    public AlojamientoService(AlojamientoRepository alojamientoRepository) {
        this.alojamientoRepository = alojamientoRepository;
    }

    public List<Alojamientos> obtenerAlojamientos() {
        return alojamientoRepository.findAll();
    }

    public Optional<Alojamientos> obtenerAlojamientoPorId(Long id) {
        return alojamientoRepository.findById(id);
    }

    public Alojamientos guardarAlojamiento(Alojamientos alojamiento) {
        return alojamientoRepository.save(alojamiento);
    }

    public void actualizarAlojamiento(Long id, Alojamientos alojamientoActualizado) {
        Optional<Alojamientos> alojamiento = alojamientoRepository.findById(id);
        if (alojamiento.isPresent()) {
            alojamientoActualizado.setId(id);
            alojamientoRepository.save(alojamientoActualizado);
        }
    }

    public void eliminarAlojamiento(Long id) {
        alojamientoRepository.deleteById(id);
    }
}
