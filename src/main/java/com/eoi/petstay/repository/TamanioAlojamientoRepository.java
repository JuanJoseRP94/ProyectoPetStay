package com.eoi.petstay.repository;


import com.eoi.petstay.model.TamanioAlojamiento;
import com.eoi.petstay.model.Tamanios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TamanioAlojamientoRepository extends JpaRepository<TamanioAlojamiento, Long> {
}
