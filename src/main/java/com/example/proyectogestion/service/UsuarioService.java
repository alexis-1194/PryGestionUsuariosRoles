package com.example.proyectogestion.service;

import com.example.proyectogestion.entity.ConfirmationToken;
import com.example.proyectogestion.bean.RegisterUserBean;
import com.example.proyectogestion.response.Response;

import java.math.BigDecimal;
import java.util.Map;

public interface UsuarioService {

    Response register(RegisterUserBean registerUserBean);

    Integer getUsuariosCount(String username);

    Response saveToken(ConfirmationToken token);

    Map<String,Object> getToken(String token);

    String confirmToken(String token);

    Response getAreasUsuario(String email);



}
