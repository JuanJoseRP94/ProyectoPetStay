package com.eoi.petstay.repository;

import com.eoi.petstay.model.Menu;
import com.eoi.petstay.model.Roles;
import com.eoi.petstay.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


public interface MenuRepository extends JpaRepository<Menu, Long>{
    List<Menu> findDistinctByRolesInAndActiveTrueOrderByOrder(Collection<Roles> roles);
}
