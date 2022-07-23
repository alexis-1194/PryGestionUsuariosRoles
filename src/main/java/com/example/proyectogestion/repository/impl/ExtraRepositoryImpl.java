package com.example.proyectogestion.repository.impl;

import com.example.proyectogestion.repository.ExtraRepository;
import com.example.proyectogestion.util.Constantes;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
@Slf4j
public class ExtraRepositoryImpl implements ExtraRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Map<String, Object> getClientes(Integer p_limit) {
        log.info("p_limit: {}", p_limit);
        Session s = em.unwrap(Session.class);
        ProcedureCall call = s.createStoredProcedureCall(Constantes.SP_LIST_CLIENTES);
        call.registerParameter(1,Integer.class, ParameterMode.IN);
        call.setParameter(1, p_limit);
        call.registerParameter(2, String.class,ParameterMode.OUT);
        call.registerParameter(3, String.class,ParameterMode.OUT);
        call.registerParameter(4, Integer.class,ParameterMode.OUT);
        call.registerParameter(5, Class.class,ParameterMode.REF_CURSOR);
        call.execute();
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_CODIGO",call.getOutputParameterValue(2));
        result.put("OUT_MSG",call.getOutputParameterValue(3));
        result.put("OUT_CANTIDAD",call.getOutputParameterValue(4));
        List<Object> list = (List<Object>) call.getResultList();
        result.put("OUT_LIST",list);
        return result;
    }

    @Override
    public Map<String, Object> getCategorias(Integer p_limit) {
        log.info("p_limit: {}", p_limit);
        Session s = em.unwrap(Session.class);
        ProcedureCall call = s.createStoredProcedureCall(Constantes.SP_LIST_CATEGORIAS);
        call.registerParameter(1,Integer.class, ParameterMode.IN);
        call.setParameter(1, p_limit);
        call.registerParameter(2, String.class,ParameterMode.OUT);
        call.registerParameter(3, String.class,ParameterMode.OUT);
        call.registerParameter(4, Integer.class,ParameterMode.OUT);
        call.registerParameter(5, Class.class,ParameterMode.REF_CURSOR);
        call.execute();
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_CODIGO",call.getOutputParameterValue(2));
        result.put("OUT_MSG",call.getOutputParameterValue(3));
        result.put("OUT_CANTIDAD",call.getOutputParameterValue(4));
        List<Object> list = (List<Object>) call.getResultList();
        result.put("OUT_LIST",list);
        return result;
    }

    @Override
    public Map<String, Object> getProductos(Integer p_limit) {
        Session s = em.unwrap(Session.class);
        ProcedureCall call = s.createStoredProcedureCall(Constantes.SP_LIST_PRODUCTOS);
        call.registerParameter(1,Integer.class, ParameterMode.IN);
        call.setParameter(1, p_limit);
        call.registerParameter(2, String.class,ParameterMode.OUT);
        call.registerParameter(3, String.class,ParameterMode.OUT);
        call.registerParameter(4, Integer.class,ParameterMode.OUT);
        call.registerParameter(5, Class.class,ParameterMode.REF_CURSOR);
        call.execute();
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_CODIGO",call.getOutputParameterValue(2));
        result.put("OUT_MSG",call.getOutputParameterValue(3));
        result.put("OUT_CANTIDAD",call.getOutputParameterValue(4));
        List<Object> list = (List<Object>) call.getResultList();
        result.put("OUT_LIST",list);
        return result;
    }

    @Override
    public Map<String, Object> getJuegos(Integer p_limit) {
        Session s = em.unwrap(Session.class);
        ProcedureCall call = s.createStoredProcedureCall(Constantes.SP_LIST_JUEGOS);
        call.registerParameter(1,Integer.class, ParameterMode.IN);
        call.setParameter(1, p_limit);
        call.registerParameter(2, String.class,ParameterMode.OUT);
        call.registerParameter(3, String.class,ParameterMode.OUT);
        call.registerParameter(4, Integer.class,ParameterMode.OUT);
        call.registerParameter(5, Class.class,ParameterMode.REF_CURSOR);
        call.execute();
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_CODIGO",call.getOutputParameterValue(2));
        result.put("OUT_MSG",call.getOutputParameterValue(3));
        result.put("OUT_CANTIDAD",call.getOutputParameterValue(4));
        List<Object> list = (List<Object>) call.getResultList();
        result.put("OUT_LIST",list);
        return result;
    }

    @Override
    public Map<String, Object> getAlmacen(Integer p_limit) {
        Session s = em.unwrap(Session.class);
        ProcedureCall call = s.createStoredProcedureCall(Constantes.SP_LIST_ALMACEN);
        call.registerParameter(1,Integer.class, ParameterMode.IN);
        call.setParameter(1, p_limit);
        call.registerParameter(2, String.class,ParameterMode.OUT);
        call.registerParameter(3, String.class,ParameterMode.OUT);
        call.registerParameter(4, Integer.class,ParameterMode.OUT);
        call.registerParameter(5, Class.class,ParameterMode.REF_CURSOR);
        call.execute();
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_CODIGO",call.getOutputParameterValue(2));
        result.put("OUT_MSG",call.getOutputParameterValue(3));
        result.put("OUT_CANTIDAD",call.getOutputParameterValue(4));
        List<Object> list = (List<Object>) call.getResultList();
        result.put("OUT_LIST",list);
        return result;
    }

    @Override
    public Map<String, Object> getProveedores(Integer p_limit) {
        Session s = em.unwrap(Session.class);
        ProcedureCall call = s.createStoredProcedureCall(Constantes.SP_LIST_PROVEEDOR);
        call.registerParameter(1,Integer.class, ParameterMode.IN);
        call.setParameter(1, p_limit);
        call.registerParameter(2, String.class,ParameterMode.OUT);
        call.registerParameter(3, String.class,ParameterMode.OUT);
        call.registerParameter(4, Integer.class,ParameterMode.OUT);
        call.registerParameter(5, Class.class,ParameterMode.REF_CURSOR);
        call.execute();
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_CODIGO",call.getOutputParameterValue(2));
        result.put("OUT_MSG",call.getOutputParameterValue(3));
        result.put("OUT_CANTIDAD",call.getOutputParameterValue(4));
        List<Object> list = (List<Object>) call.getResultList();
        result.put("OUT_LIST",list);
        return result;
    }
}
