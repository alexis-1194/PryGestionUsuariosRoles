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
    public Response listarClientes(@PathVariable Integer limit){
        return extraService.getClientes(limit);
    }

    @GetMapping(value = "/categorias/{limit}", produces = "application/json")
    public Response listarCategorias(@PathVariable Integer limit){
        return extraService.getCategorias(limit);
    }

    @GetMapping(value = "/productos/{limit}", produces = "application/json")
    public Response listarProductos(@PathVariable Integer limit){
        return extraService.getProdcutos(limit);
    }

    @GetMapping(value = "/yale", produces = "application/json")
    public String test(){
      return  "Gordita te extraño";
    }

}
