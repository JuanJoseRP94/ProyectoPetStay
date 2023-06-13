package com.eoi.petstay.repository;

import com.eoi.petstay.model.Mascotas;
import com.eoi.petstay.model.TipoCuidados;
import com.eoi.petstay.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


public interface MascotasRepository extends JpaRepository<Mascotas, Long>{
    Set<Mascotas> findByMascotaHasComportamientosComportamientoId(Long comportamientoId);
    Set<Mascotas> findByMascotasRequiereCuidadosCuidadosId(Long cuidadosId);
}
