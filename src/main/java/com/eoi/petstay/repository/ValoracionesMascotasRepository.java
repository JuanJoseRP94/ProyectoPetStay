package com.eoi.petstay.repository;

import com.eoi.petstay.model.ValoracionesMascotas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoracionesMascotasRepository extends JpaRepository<ValoracionesMascotas, Long> {
}
