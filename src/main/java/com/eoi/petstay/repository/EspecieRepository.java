package com.eoi.petstay.repository;

import com.eoi.petstay.model.Especie;
import com.eoi.petstay.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EspecieRepository extends JpaRepository<Especie, Long>{
}
