package com.eoi.petstay.repository;

import com.eoi.petstay.model.Alojamientos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlojamientoRepository extends JpaRepository<Alojamientos, Long> {
    //Para ver si el usuario esxite
}