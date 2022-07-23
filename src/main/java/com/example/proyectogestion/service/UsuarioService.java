package com.example.proyectogestion.service;

import com.example.proyectogestion.entity.ConfirmationToken;
import com.example.proyectogestion.requestbean.RegisterUserBean;
import com.example.proyectogestion.response.Response;

public interface UsuarioService {

    Response register(RegisterUserBean registerUserBean);

    Integer getUsuariosCount(String username);

    Response saveToken(ConfirmationToken token);

}
