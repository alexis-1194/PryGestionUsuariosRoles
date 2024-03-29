package com.example.proyectogestion.repository;

import com.example.proyectogestion.entity.ConfirmationToken;
import com.example.proyectogestion.bean.RegisterUserBean;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UsuarioRepository {
    Map<String,Object> register(RegisterUserBean registerUserBean);
    Integer getUsuariosCount(String username);
    Map<String,Object> guardarToken(ConfirmationToken token);
    Map<String,Object> getToken(String token);
    Map<String,Object> getAreasUsuario(String email);
}
