package com.eoi.petstay.repository;

import com.eoi.petstay.model.Mascotas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/*
    Puesto que vamos a presentar las listas con paginación, extendemos el repositorio también
    desde PagingAndSortingRepository para aprovechar los métodos que publica.
 */
public interface MascotasRepo extends JpaRepository<Mascotas, Long>, PagingAndSortingRepository<Mascotas, Long> {

    @Query("SELECT m FROM Mascotas m WHERE m.usuario.id=:id")
    Page<Mascotas> listaMascotasUsuario(@Param("id") Long id, Pageable pageReq);
}
