package com.eoi.petstay.repository;

import com.eoi.petstay.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //Para ver si el usuario esxite
    Usuario findUsuarioByEmailAndActiveTrue(String email);
}