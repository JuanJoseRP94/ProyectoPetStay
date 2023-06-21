package com.eoi.petstay.repository;

import com.eoi.petstay.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //Para ver si el usuario existe
    Optional<Usuario> findUsuarioByEmailAndActiveTrue(String email);
    Optional<Usuario> findByEmailAndPasswordAndActiveTrue(String usr, String pass);

    Usuario findByEmailAndActiveTrue(String email);

    Usuario findUsuarioByEmailAndPassword(String email, String password);

    @Query("Select count(u.id) from Usuario u where u.email= ?1")
    Integer repValidarEmail(String email);

    Usuario findUsuarioByEmail(String email);
}