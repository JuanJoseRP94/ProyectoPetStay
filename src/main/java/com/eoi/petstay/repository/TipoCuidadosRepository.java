package com.eoi.petstay.repository;

import com.eoi.petstay.model.TipoCuidados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TipoCuidadosRepository extends JpaRepository<TipoCuidados, Long> {

}
