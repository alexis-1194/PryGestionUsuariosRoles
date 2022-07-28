package com.example.proyectogestion.bean;

import lombok.Data;

@Data
public class UsuarioBean {
    private String username;
    private String pwd;
    private Character estado;
    private String rol;
}
