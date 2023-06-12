package com.eoi.petstay.repository;

import com.eoi.petstay.model.Alojamientos;
import com.eoi.petstay.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamientos, Long> {
    //Para ver si el usuario esxite
}