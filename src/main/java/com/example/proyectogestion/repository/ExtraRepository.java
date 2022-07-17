package com.example.proyectogestion.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ExtraRepository {

    Map<String,Object> getClientes(Integer p_limit);

    Map<String,Object> getCategorias(Integer p_limit);

    Map<String,Object> getProductos(Integer p_limit);

}
