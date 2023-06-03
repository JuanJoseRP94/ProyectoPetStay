package com.eoi.petstay.repository;

import com.eoi.petstay.model.Roles;
import com.eoi.petstay.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
    //Para ver si el usuario esxite
}