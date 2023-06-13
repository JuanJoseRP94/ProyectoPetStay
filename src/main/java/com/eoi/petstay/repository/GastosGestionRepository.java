package com.eoi.petstay.repository;

import com.eoi.petstay.model.GastosGestion;
import com.eoi.petstay.model.Usuarios;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GastosGestionRepository extends JpaRepository<GastosGestion, Long>{
}
