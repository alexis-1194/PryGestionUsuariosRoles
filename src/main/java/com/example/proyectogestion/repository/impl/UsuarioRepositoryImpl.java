package com.example.proyectogestion.repository.impl;

import com.example.proyectogestion.repository.UsuarioRepository;
import com.example.proyectogestion.requestbean.RegisterUserBean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Map;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager em;
    @Override
    public Map<String,Object> register(RegisterUserBean registerUserBean) {
        return null;
    }

    @Override
    public Integer getUsuariosCount(String username) {
        return null;
    }
}
