package com.example.proyectogestion.rest;

import com.example.proyectogestion.response.Response;
import com.example.proyectogestion.service.ExtraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pruebas")
@RequiredArgsConstructor
public class ExtraController {

    private final ExtraService extraService;

    @GetMapping(value = "/clientes/{limit}", produces = "application/json")
    public Response listarClientes(@PathVariable Integer limit) {
        return extraService.getClientes(limit);
    }

    @GetMapping(value = "/categorias/{limit}", produces = "application/json")
    public Response listarCategorias(@PathVariable Integer limit) {
        return extraService.getCategorias(limit);
    }

    @GetMapping(value = "/productos/{limit}", produces = "application/json")
    public Response listarProductos(@PathVariable Integer limit) {
        return extraService.getProductos(limit);
    }

    @GetMapping(value = "/juegos/{limit}", produces = "application/json")
    public Response listarJuegos(@PathVariable Integer limit) {
        return extraService.getJuegos(limit);
    }

    @GetMapping(value = "/almacen/{limit}", produces = "application/json")
    public Response listarAlmacen(@PathVariable Integer limit) {
        return extraService.getAlmacen(limit);
    }

    @GetMapping(value = "/proveedores/{limit}", produces = "application/json")
    public Response listarProveedores(@PathVariable Integer limit) {
        return extraService.getProveedores(limit);
    }

}
