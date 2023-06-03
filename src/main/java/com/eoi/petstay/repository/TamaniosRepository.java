package com.eoi.petstay.repository;


import com.eoi.petstay.model.Tamanios;
import com.eoi.petstay.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TamaniosRepository extends JpaRepository<Tamanios, Long> {
}
