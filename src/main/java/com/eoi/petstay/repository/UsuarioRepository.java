package com.eoi.petstay.repository;

import com.eoi.petstay.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    //Para ver si el usuario esxite
    Optional<Usuarios> findUsuarioByEmailAndActiveTrue(String email);
    Optional<Usuarios> findByEmailAndPasswordAndActiveTrue(String usr, String pass);

}