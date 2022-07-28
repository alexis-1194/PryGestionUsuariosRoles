package com.example.proyectogestion.service.impl;

import com.example.proyectogestion.entity.*;
import com.example.proyectogestion.repository.ExtraRepository;
import com.example.proyectogestion.response.Response;
import com.example.proyectogestion.service.ExtraService;
import com.example.proyectogestion.util.Constantes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ExtraServiceImpl implements ExtraService {

    private final ExtraRepository extraRepository;

    @Override
    public Response getClientes(Integer p_limit) {
        Response response = new Response();
        Map<String, Object> result = new HashMap<>();
        try {
            result = extraRepository.getClientesV2(p_limit);
            if (result.get("OUT_CODIGO").equals(Constantes.CODIGO_OK)) {
                response.setStatusCode(result.get("OUT_CODIGO").toString());
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage(result.get("OUT_MSG").toString());
                response.setDeveloperMessage("OK");
                response.setData(Map.of("data", result.get("OUT_LIST"), "cantidad", result.get("OUT_CANTIDAD")));
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

    @Override
    public Response getCategorias(Integer p_limit) {
        Response response = new Response();
        Map<String, Object> result = new HashMap<>();
        try {
            result = extraRepository.getCategorias(p_limit);
            if (result.get("OUT_CODIGO").equals(Constantes.CODIGO_OK)) {
                response.setStatusCode(result.get("OUT_CODIGO").toString()); //este es el estado de las peticiones de la bd para ser tratados en bd
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage(result.get("OUT_MSG").toString());
                response.setDeveloperMessage("SUCCESS");
                response.setData(Map.of("data", result.get("OUT_CURSOR"), "cantidad", result.get("OUT_CANTIDAD")));
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

    @Override
    public Response getProductos(Integer p_limit) {
        Response response = new Response();
        Map<String, Object> result = new HashMap<>();
        try {
            result = extraRepository.getProductos(p_limit);
            if (result.get("OUT_CODIGO").equals("0000")) {
                response.setStatusCode(result.get("OUT_CODIGO").toString());
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage(result.get("OUT_MSG").toString());
                response.setDeveloperMessage("OK");
//                List<Object> listaPrevia = (List<Object>) result.get("OUT_LIST");
//                List<Producto> listaFinal = listaPrevia.stream().map(p -> new Producto(p)).collect(Collectors.toList());
                response.setData(Map.of("data", result.get("OUT_LIST"), "cantidad", result.get("OUT_CANTIDAD")));
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

    @Override
    public Response getJuegos(Integer p_limit) {
        Response response = new Response();
        Map<String, Object> result = new HashMap<>();
        try {
            result = extraRepository.getJuegos(p_limit);
            if (result.get("OUT_CODIGO").equals(Constantes.CODIGO_OK)) {
                response.setStatusCode(result.get("OUT_CODIGO").toString());
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage(result.get("OUT_MSG").toString());
                response.setDeveloperMessage("OK");
                response.setData(Map.of("data", result.get("OUT_LIST"), "cantidad", result.get("OUT_CANTIDAD")));
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
        }
        return response;
    }

    @Override
    public Response getAlmacen(Integer p_limit) {
        Response response = new Response();
        Map<String, Object> result = new HashMap<>();
        try {
            result = extraRepository.getAlmacen(p_limit);
            if (result.get("OUT_CODIGO").equals(Constantes.CODIGO_OK)) {
                response.setStatusCode(result.get("OUT_CODIGO").toString());
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage(result.get("OUT_MSG").toString());
                response.setDeveloperMessage("OK");
                response.setData(Map.of("data", result.get("OUT_LIST"), "cantidad", result.get("OUT_CANTIDAD")));
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

    @Override
    public Response getProveedores(Integer p_limit) {
        Response response = new Response();
        Map<String, Object> result = new HashMap<>();
        try {
            result = extraRepository.getProveedores(p_limit);
            if (result.get("OUT_CODIGO").equals(Constantes.CODIGO_OK)) {
                response.setStatusCode(result.get("OUT_CODIGO").toString());
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage(result.get("OUT_MSG").toString());
                response.setDeveloperMessage("OK");
                response.setData(Map.of("data", result.get("OUT_LIST"), "cantidad", result.get("OUT_CANTIDAD")));
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
            Map<String, Object>
                    error = new HashMap<>();
            error.put("trama", e.getStackTrace());
            response.setError(error);
        }
        return response;
    }
}
