package com.example.proyectogestion.rest;

import com.example.proyectogestion.response.Response;
import com.example.proyectogestion.service.ExtraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final ExtraService eS;

    @RequestMapping("/clientes/{p_limit}")
    public Response getClientes(@PathVariable Integer p_limit) {
        return eS.getClientes(p_limit);
    }



}
