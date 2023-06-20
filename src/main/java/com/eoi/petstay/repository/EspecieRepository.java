package com.eoi.petstay.repository;

import com.eoi.petstay.model.Especie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EspecieRepository extends JpaRepository<Especie, Long>{

    Especie findByNombreEspecie(String strEspecie);
}
