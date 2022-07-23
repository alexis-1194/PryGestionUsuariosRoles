package com.example.proyectogestion.repository.impl;

import com.example.proyectogestion.entity.ConfirmationToken;
import com.example.proyectogestion.repository.UsuarioRepository;
import com.example.proyectogestion.requestbean.RegisterUserBean;
import com.example.proyectogestion.util.Constantes;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Map<String, Object> register(RegisterUserBean registerUserBean) {
        Session s = em.unwrap(Session.class);
        ProcedureCall call = s.createStoredProcedureCall(Constantes.sp_usuario_insert);
        call.registerParameter(1, String.class, ParameterMode.IN);
        call.setParameter(1, registerUserBean.getApePat());
        call.registerParameter(2, String.class, ParameterMode.IN);
        call.setParameter(2, registerUserBean.getApeMat());
        call.registerParameter(3, String.class, ParameterMode.IN);
        call.setParameter(3, registerUserBean.getNombres());
        call.registerParameter(4, String.class, ParameterMode.IN);
        call.setParameter(4, registerUserBean.getUsuEmail());
        call.registerParameter(5, String.class, ParameterMode.IN);
        call.setParameter(5, registerUserBean.getUsuPwd());
        call.registerParameter(6, BigDecimal.class, ParameterMode.OUT);
        call.registerParameter(7, String.class, ParameterMode.OUT);
        call.registerParameter(8, String.class, ParameterMode.OUT);
        call.execute();
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_USUARIO_ID", call.getOutputParameterValue(6));
        result.put("OUT_CODIGO", call.getOutputParameterValue(7));
        result.put("OUT_MSG", call.getOutputParameterValue(8));

        return result;
    }

    @Override
    public Integer getUsuariosCount(String username) {
        Session s = em.unwrap(Session.class);
        ProcedureCall call = s.createStoredProcedureCall(Constantes.sp_usuario_exists);
        call.registerParameter(1, String.class, ParameterMode.IN);
        call.setParameter(1, username);
        call.registerParameter(2, String.class, ParameterMode.OUT);
        call.execute();
        Integer codigo = call.getOutputParameterValue(2).equals("0000") ? 1 : 0;
        return codigo;
    }

    @Override
    public Map<String, Object> guardarToken(ConfirmationToken token) {
        Session s = em.unwrap(Session.class);
        ProcedureCall call = s.createStoredProcedureCall(Constantes.sp_guardar_token);//cambiar el sp
        call.registerParameter(1, BigDecimal.class, ParameterMode.IN).enablePassingNulls(true);
        call.setParameter(1, token.getTokenId());
        call.registerParameter(2, Timestamp.class, ParameterMode.IN).enablePassingNulls(true);
        call.setParameter(2, token.getConfirmedAt());
        call.registerParameter(3, Timestamp.class, ParameterMode.IN);
        call.setParameter(3, token.getExpiresAt());
        call.registerParameter(4, String.class, ParameterMode.IN);
        call.setParameter(4, token.getToken());
        call.registerParameter(5, BigDecimal.class, ParameterMode.IN);
        call.setParameter(5, token.getUsuId());

        call.registerParameter(6, String.class, ParameterMode.OUT);
        call.registerParameter(7, String.class, ParameterMode.OUT);
        call.execute();
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_CODIGO", call.getOutputParameterValue(6));
        result.put("OUT_MSG", call.getOutputParameterValue(7));
        return result;
    }
}
