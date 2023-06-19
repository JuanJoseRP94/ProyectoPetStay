package com.eoi.petstay.repository;

import com.eoi.petstay.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    //Para ver si el usuario existe
    Optional<Usuarios> findUsuarioByEmailAndActiveTrue(String email);
    Optional<Usuarios> findByEmailAndPasswordAndActiveTrue(String usr, String pass);

    Usuarios findByEmailAndActiveTrue(String email);

    Usuarios findUsuarioByEmailAndPassword(String email, String password);

    @Query("Select count(id) from Usuario where email= ?1 and password = ?2")
    Integer repValidarEmail(String email);

    Usuarios findUsuarioByEmail(String email);
}