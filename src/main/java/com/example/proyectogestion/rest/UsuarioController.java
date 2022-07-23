package com.example.proyectogestion.rest;

import com.example.proyectogestion.requestbean.RegisterUserBean;
import com.example.proyectogestion.response.Response;
import com.example.proyectogestion.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping(value = "/registrar", produces = "application/json")
    public Response listarClientes(@RequestBody RegisterUserBean registerUserBean) {
        return usuarioService.register(registerUserBean);
    }

}
