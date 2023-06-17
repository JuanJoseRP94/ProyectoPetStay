package com.eoi.petstay.repository;


import com.eoi.petstay.model.TipoAlojamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAlojamientoRepository extends JpaRepository<TipoAlojamiento, Long> {
}
