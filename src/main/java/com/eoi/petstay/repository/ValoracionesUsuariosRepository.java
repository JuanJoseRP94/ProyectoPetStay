package com.eoi.petstay.repository;

import com.eoi.petstay.model.ValoracionesUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoracionesUsuariosRepository extends JpaRepository<ValoracionesUsuarios, Long> {
}
