package com.eoi.petstay.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "img")
public class ConfigProperties {
    private String protocolo;
    private String servidor;
    private int puerto;
    private String ruta;
    // standard getters and setters
}