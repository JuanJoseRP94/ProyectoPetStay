package com.eoi.petstay.repository;

import com.eoi.petstay.model.Oferta;
import com.eoi.petstay.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OfertaRepository extends JpaRepository<Oferta, Long>{
}
