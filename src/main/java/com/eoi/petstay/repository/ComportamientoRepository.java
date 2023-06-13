
package com.eoi.petstay.repository;

import com.eoi.petstay.model.Comportamientos;
import com.eoi.petstay.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ComportamientoRepository extends JpaRepository<Comportamientos, Long>{
}
