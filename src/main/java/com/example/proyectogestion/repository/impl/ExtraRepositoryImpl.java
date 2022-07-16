package com.example.proyectogestion.repository.impl;

import com.example.proyectogestion.repository.ExtraRepository;
import com.example.proyectogestion.util.Constantes;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import java.util.Map;

@Repository
public class ExtraRepositoryImpl implements ExtraRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Map<String, Object> getClientes(Integer p_limit) {
        Session s = em.unwrap(Session.class);
        ProcedureCall call = s.createStoredProcedureCall(Constantes.SP_LIST_CATEGORIAS);
        call.registerParameter(1,Integer.class, ParameterMode.IN);
        call.setParameter(1, p_limit);

        return null;
    }
}
