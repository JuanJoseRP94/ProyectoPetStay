package com.eoi.petstay.repository;

import com.eoi.petstay.model.Especie;
import com.eoi.petstay.model.Roles;
import com.eoi.petstay.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface EspecieRepository extends JpaRepository<Especie, Long>{

    Optional<Especie> findByNombreEspecie(String strEspecie);
}
