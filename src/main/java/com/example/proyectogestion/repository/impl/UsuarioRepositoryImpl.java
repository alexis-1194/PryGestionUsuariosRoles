package com.example.proyectogestion.repository.impl;

import com.example.proyectogestion.repository.UsuarioRepository;
import com.example.proyectogestion.requestbean.RegisterUserBean;
import com.example.proyectogestion.util.Constantes;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import java.util.Map;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager em;
    @Override
    public Map<String,Object> register(RegisterUserBean registerUserBean) {
        Session s = em.unwrap(Session.class);
        ProcedureCall call = s.createStoredProcedureCall(Constantes.SP_REGISTER_USER);

        return null;
    }

    @Override
    public Integer getUsuariosCount(String username) {
        Session s = em.unwrap(Session.class);
        ProcedureCall call = s.createStoredProcedureCall(Constantes.sp_usuario_exists);
        call.registerParameter(1,String.class, ParameterMode.IN);
        call.setParameter(1, username);
        call.registerParameter(2,String.class, ParameterMode.OUT);
        call.execute();
        Integer codigo = (Integer) call.getOutputParameterValue(2);
        return codigo;
    }
}
