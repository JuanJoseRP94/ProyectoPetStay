package com.eoi.petstay.repository;

import com.eoi.petstay.model.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    //Para ver si el usuario esxite
    Usuarios findUsuarioByEmailAndActiveTrue(String email);


    Page<Usuarios> findAll(Pageable pageable);


}