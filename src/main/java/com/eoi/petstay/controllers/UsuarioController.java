package com.eoi.petstay.controllers;

import com.eoi.petstay.models.Alojamientos;
import com.eoi.petstay.models.Roles;
import com.eoi.petstay.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioController {
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setFoto("foto");
        usuario.setNombre("Juancho");
        usuario.setApellido("Romero");
        usuario.setApellido2("Palacios");
        usuario.setValoracion("4");
        usuario.setSexo("masculino");
        usuario.setEmail("juancho.rom.pal@gmail.com");
        usuario.setTelefono("75932378");
        usuario.setPassword("password");
        usuario.setRol();
        usuario.setAlojamientos();
        return usuario;
    }
    @RequestMapping(value = "usuario453545")
    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juancho");
        usuario.setApellido("Romero");
        usuario.setEmail("juancho.rom.pal@gmail.com");
        usuario.setTelefono("75932378");
        return usuario;
    }
    @RequestMapping(value = "usuario45353")
    public Usuario eliminar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juancho");
        usuario.setApellido("Romero");
        usuario.setEmail("juancho.rom.pal@gmail.com");
        usuario.setTelefono("75932378");
        return usuario;
    }
    @RequestMapping(value = "usuario453543")
    public Usuario buscar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juancho");
        usuario.setApellido("Romero");
        usuario.setEmail("juancho.rom.pal@gmail.com");
        usuario.setTelefono("75932378");
        return usuario;
    }
}