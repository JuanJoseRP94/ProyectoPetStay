package com.eoi.petstay.repository;

import com.eoi.petstay.model.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EspecieRepository extends JpaRepository<Especie, Long>{

    Optional<Especie> findByNombreEspecie(String strEspecie);
}
