package com.eoi.petstay.repository;

import com.eoi.petstay.model.Mascotas;
import com.eoi.petstay.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MascotasRepository extends JpaRepository<Mascotas, Long>{
    // como buscar mascotas
    // Optional<Mascotas> ;
}
