package com.eoi.petstay.config;



import com.eoi.petstay.model.Mascotas;
import com.eoi.petstay.model.Usuario;
import com.eoi.petstay.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioSecurityImpl implements IUsuarioServicio, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public String getEncodedPassword(Usuario usuario) {
        String passwd = usuario.getPassword();
        String encodedPasswod = passwordEncoder.encode(passwd);
        return encodedPasswod;
    }

    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public Page<Mascotas> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername email : " + email);
        Optional<Usuario> usuariosOptional = usuarioRepository.findUsuarioByEmailAndActiveTrue(email);
        //Variables de gestion de seguridad
        org.springframework.security.core.userdetails.User springUser=null;
        Set<GrantedAuthority> ga = new HashSet<>();

        if (usuariosOptional.isPresent()){
            System.out.println("loadUserByUsername usuario : " + usuariosOptional.get().getNombre());
            ga.add(new SimpleGrantedAuthority(usuariosOptional.get().getRole().getRoleName()));

            springUser = new org.springframework.security.core.userdetails.User(
                    email,
                    usuariosOptional.get().getPassword(),
                    ga );
        } else {
            String email_anonimo = "anonimo@anonimo";
            String pass = "***********";
            springUser = new org.springframework.security.core.userdetails.User(
                    email_anonimo,
                    pass,
                    ga );
        }
        return springUser;

    }
}


