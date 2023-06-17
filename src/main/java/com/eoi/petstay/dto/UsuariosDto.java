package com.eoi.petstay.dto;

import com.eoi.petstay.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsuariosDto {

    private long id;
    private String foto;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private float valoracion;
    private String email;
    private String telefono;
    private String password;

    private boolean active;

    // Dependencias

    private Long role;
    private Long alojamientos;
    private Long gastosGestion;
    private Set<ValoracionesMascotas> valoracionesMascotas = new HashSet<>();
    private Set<ValoracionesUsuarios> valoracionesUsuarios = new HashSet<>();
    private Set<Oferta> oferta = new HashSet<>();
    private Set<Mascotas> mascotas = new HashSet<>();

}
