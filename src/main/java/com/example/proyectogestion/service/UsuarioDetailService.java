package com.example.proyectogestion.service;

import com.example.proyectogestion.response.Response;

import java.math.BigDecimal;
import java.util.Map;

public interface UsuarioDetailService {

    Response getUsuarios(BigDecimal id);

}
