package com.example.proyectogestion.service.impl;

import com.example.proyectogestion.repository.ExtraRepository;
import com.example.proyectogestion.response.Response;
import com.example.proyectogestion.service.ExtraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class ExtraServiceImpl implements ExtraService {

    private final ExtraRepository extraRepository;

    @Override
    public Response getClientes(Integer p_limit) {
        Response response = new Response();
        try {
            Map<String,Object> result = extraRepository.getClientes(p_limit);
            if (result.get("OUT_CODIGO").equals("0000")){
                response.setStatusCode(200);
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage("Se obtuvieron los clientes correctamente");
                response.setDeveloperMessage("OK");
                Map<String,Object> data = new HashMap<>();
                data.put("cantidad",result.get("OUT_CANTIDAD"));
                data.put("estado",result.get("OUT_CODIGO"));
                data.put("data",result.get("OUT_LIST"));
                response.setData(data);
                response.setError(null);
            }

        }catch (Exception e) {
            e.printStackTrace();

        }

        return response;
    }

    @Override
    public Response getCategorias(Integer p_limit) {
        Response response = new Response();
        try {
            Map<String,Object> result = extraRepository.getCategorias(p_limit);
            if (result.get("OUT_CODIGO").equals("0000")){
                response.setStatusCode(200);
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage("Se obtuvieron los clientes correctamente");
                response.setDeveloperMessage("OK");
                Map<String,Object> data = new HashMap<>();
                data.put("cantidad",result.get("OUT_CANTIDAD"));
                data.put("estado",result.get("OUT_CODIGO"));
                data.put("data",result.get("OUT_LIST"));
                response.setData(data);
                response.setError(null);
            }

        }catch (Exception e) {
            e.printStackTrace();

        }

        return response;
    }

    @Override
    public Response getProdcutos(Integer p_limit) {
        Response response = new Response();
        try {
            Map<String,Object> result = extraRepository.getProductos(p_limit);
            if (result.get("OUT_CODIGO").equals("0000")){
                response.setStatusCode(200);
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage("Se obtuvieron los clientes correctamente");
                response.setDeveloperMessage("OK");
                Map<String,Object> data = new HashMap<>();
                data.put("cantidad",result.get("OUT_CANTIDAD"));
                data.put("estado",result.get("OUT_CODIGO"));
                data.put("data",result.get("OUT_LIST"));
                response.setData(data);
                response.setError(null);
            }

        }catch (Exception e) {
            e.printStackTrace();

        }

        return response;
    }
}
