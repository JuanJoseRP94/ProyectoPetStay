package com.eoi.petstay.repository;

import com.eoi.petstay.model.ImagenesAlojamiento;
import com.eoi.petstay.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenesAlojamientoRepository extends JpaRepository<ImagenesAlojamiento, Long>{
}
