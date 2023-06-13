package com.eoi.petstay.repository;

import com.eoi.petstay.model.Mascotas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MascotasRepository extends JpaRepository<Mascotas, Long>{
    // como buscar mascotas
    // Optional<Mascotas> ;

}
