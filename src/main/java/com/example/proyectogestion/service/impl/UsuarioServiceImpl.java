package com.example.proyectogestion.service.impl;

import com.example.proyectogestion.entity.Cliente;
import com.example.proyectogestion.repository.UsuarioRepository;
import com.example.proyectogestion.requestbean.RegisterUserBean;
import com.example.proyectogestion.response.Response;
import com.example.proyectogestion.service.UsuarioService;
import com.example.proyectogestion.util.Constantes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Response register(RegisterUserBean registerUserBean) {
        Response response = new Response();
        Map<String, Object> result = new HashMap<>();;

        try {

            //validando si el usuario ya existe
            if(getUsuariosCount(registerUserBean.getUsuEmail())==0) {
                response.setStatusCode("9999");
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage("El usuario ya existe en la bd");
                response.setDeveloperMessage("OK");
                response.setData(null);
                response.setError(null);
                return response;
            }

            result = usuarioRepository.register(registerUserBean);
            //paso
            if (result.get("OUT_CODIGO").equals(Constantes.CODIGO_OK)) {
                //OUT_USUARIO_ID
                response.setStatusCode(result.get("OUT_CODIGO").toString());
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage(result.get("OUT_MSG").toString());
                response.setDeveloperMessage("OK");
                response.setError(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatusCode(Constantes.CODIGO_ERROR);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setReason("ERROR");
            response.setMessage(result.get("OUT_MSG").toString());
            response.setDeveloperMessage(e.getMessage());
            Map<String, Object> error = new HashMap<>();
            error.put("trama", e.getStackTrace());
            response.setError(error);
        }
        return response;
    }

    @Override
    public Integer getUsuariosCount(String username) {
        return usuarioRepository.getUsuariosCount(username);
    }
}
