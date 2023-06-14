package com.eoi.petstay.repository;

import com.eoi.petstay.model.Roles;
import com.eoi.petstay.model.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SexoRepository extends JpaRepository<Sexo, Long> {
    //Para ver si el usuario existe

}