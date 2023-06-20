package com.eoi.petstay.repository;

import com.eoi.petstay.model.Oferta;
import com.eoi.petstay.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OfertaRepository extends JpaRepository<Oferta, Long>{

    List<Oferta> findByUsuarioOfertante(Usuario usuario);
}
