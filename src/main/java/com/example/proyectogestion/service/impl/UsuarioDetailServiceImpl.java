package com.example.proyectogestion.service.impl;

import com.example.proyectogestion.repository.UsuRepoDetailService;
import com.example.proyectogestion.response.Response;
import com.example.proyectogestion.service.UsuarioDetailService;
import com.example.proyectogestion.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UsuarioDetailServiceImpl implements UsuarioDetailService {

    private final UsuRepoDetailService usuRepoDetailService;

    @Override
    public Response getUsuarios(BigDecimal id){
        Response response = new Response();
        Map<String, Object> result = new HashMap<>();

        try {
            result = usuRepoDetailService.getUsuarios(id);
            //paso
            if (result.get("OUT_CODIGO").equals(Constantes.CODIGO_OK)) {
                response.setStatusCode(result.get("OUT_CODIGO").toString());
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage(result.get("OUT_MSG").toString());
                response.setDeveloperMessage("OK");
                response.setData(Map.of("data", result.get("OUT_LIST")));
                response.setError(null);
            }
            if (result.get("OUT_CODIGO").equals(Constantes.CODIGO_NO_SE_ENCONTRARON_DATOS)) {
                response.setStatusCode(result.get("OUT_CODIGO").toString());
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage(result.get("OUT_MSG").toString());
                response.setDeveloperMessage("OK");
                response.setData(null);
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

}
