package com.eoi.petstay.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "file")
public class ConfigProperties {
    private String hostName;
    private int port;
    private String  pathimg;
    // standard getters and setters
}