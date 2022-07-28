package com.example.proyectogestion.rest;

import com.example.proyectogestion.bean.RegisterUserBean;
import com.example.proyectogestion.response.Response;
import com.example.proyectogestion.service.UsuarioDetailService;
import com.example.proyectogestion.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioDetailService usuarioDetailService;



    @PostMapping(value = "/registrar", produces = "application/json")
    public Response listarClientes(@RequestBody RegisterUserBean registerUserBean) {
        return usuarioService.register(registerUserBean);
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token) {
        return usuarioService.confirmToken(token);
    }

    @GetMapping("/areasUsuario")
    public Response obtenerAreasUsuario(@RequestParam("email") String email) {
        return usuarioService.getAreasUsuario(email);
    }

    @GetMapping("/rolesUsuario")
    public Response obtenerRolesUsuario(@RequestParam("id") BigDecimal id) {
        return usuarioDetailService.getUsuarios(id);
    }

}
