package com.example.proyectogestion.service;

import com.example.proyectogestion.response.Response;

public interface ExtraService {
    Response getClientes(Integer p_limit);
    Response getCategorias(Integer p_limit);
    Response getProdcutos(Integer p_limit);
}
