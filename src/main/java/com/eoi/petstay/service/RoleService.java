package com.eoi.petstay.service;


import com.eoi.petstay.model.Roles;
import com.eoi.petstay.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractBusinessServiceSoloEnt<Roles,Long,
        RoleRepository>   {
    //
    //Acceso a los datos de la bbdd
    public RoleService(RoleRepository repo) {

        super(repo);
    }



}
