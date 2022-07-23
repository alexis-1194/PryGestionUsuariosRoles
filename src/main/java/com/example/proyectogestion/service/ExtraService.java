package com.example.proyectogestion.service;

import com.example.proyectogestion.response.Response;

public interface ExtraService {
    Response getClientes(Integer p_limit);
    Response getCategorias(Integer p_limit);
    Response getProductos(Integer p_limit);

    //TODO: getJuegos, getAlmacen, getProveedores
    Response getJuegos(Integer p_limit);
    Response getAlmacen(Integer p_limit);
    Response getProveedores(Integer p_limit);

}
