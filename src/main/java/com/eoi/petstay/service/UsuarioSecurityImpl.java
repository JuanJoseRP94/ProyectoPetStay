package com.eoi.petstay.service;



import com.eoi.petstay.model.Usuarios;
import com.eoi.petstay.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsuarioSecurityImpl implements IUsuarioServicio, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public String getEncodedPassword(Usuarios usuarios) {
        String passwd = usuarios.getPassword();
        String encodedPasswod = passwordEncoder.encode(passwd);
        return encodedPasswod;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername email : " + email);
        Usuarios usuarios = usuarioRepository.findUsuarioByEmailAndActiveTrue(email);
        System.out.println("loadUserByUsername usuario : " + usuarios.getNombre());

        org.springframework.security.core.userdetails.User springUser=null;

        Set<GrantedAuthority> ga = new HashSet<>();
        ga.add(new SimpleGrantedAuthority(usuarios.getRoles().getRoleName()));

        springUser = new org.springframework.security.core.userdetails.User(
                email,
                usuarios.getPassword(),
                ga );
        return springUser;
    }
}


