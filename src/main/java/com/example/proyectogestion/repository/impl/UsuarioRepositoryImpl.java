package com.example.proyectogestion.repository.impl;

import com.example.proyectogestion.entity.ConfirmationToken;
import com.example.proyectogestion.repository.UsuarioRepository;
import com.example.proyectogestion.bean.RegisterUserBean;
import com.example.proyectogestion.util.Constantes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleTypes;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final ApplicationContext context;


    @Override
    public Map<String, Object> register(RegisterUserBean registerUserBean) {
        log.info("register was called");
        String poolConnection = "rockjdbc";
        JdbcTemplate jdbcTemplate = context.getBean(poolConnection, JdbcTemplate.class);
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
        jdbcCall.withSchemaName(Constantes.SCHEMA);
        jdbcCall.withCatalogName(Constantes.CATALOG);
        jdbcCall.withProcedureName("sp_ins_persona_usuario");
        jdbcCall.declareParameters(
                new SqlParameter("p_apePat", OracleTypes.VARCHAR),
                new SqlParameter("p_apeMat",OracleTypes.VARCHAR),
                new SqlParameter("p_nombres",OracleTypes.VARCHAR),
                new SqlParameter("p_usuEmail",OracleTypes.VARCHAR),
                new SqlParameter("p_usuPwd",OracleTypes.VARCHAR),
                new SqlOutParameter("OUT_USUARIO_ID",OracleTypes.NUMBER),
                new SqlOutParameter("OUT_CODIGO",OracleTypes.VARCHAR),
                new SqlOutParameter("OUT_MSG",OracleTypes.VARCHAR)
        );
    jdbcCall.withoutProcedureColumnMetaDataAccess();
    Map<String,Object> inParams = new HashMap<>();
    inParams.put("p_apePat",registerUserBean.getApePat());
    inParams.put("p_apeMat",registerUserBean.getApeMat());
    inParams.put("p_nombres",registerUserBean.getNombres());
    inParams.put("p_usuEmail",registerUserBean.getUsuEmail());
    inParams.put("p_usuPwd",registerUserBean.getUsuPwd());
    Map<String,Object> outParams = jdbcCall.execute(inParams);
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_USUARIO_ID", outParams.get("OUT_USUARIO_ID"));
        result.put("OUT_CODIGO", outParams.get("OUT_CODIGO"));
        result.put("OUT_MSG", outParams.get("OUT_MSG"));
        result.put("OUT_USUARIO", registerUserBean);
        return result;
    }

    @Override
    public Integer getUsuariosCount(String username) {

        String poolConnection = "rockjdbc";
        JdbcTemplate jdbcTemplate = context.getBean(poolConnection, JdbcTemplate.class);
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
        jdbcCall.withSchemaName(Constantes.SCHEMA);
        jdbcCall.withCatalogName(Constantes.CATALOG);
        jdbcCall.withProcedureName("sp_usuario_exists");
        jdbcCall.declareParameters(
                new SqlParameter("p_username", OracleTypes.VARCHAR),
                new SqlOutParameter("OUT_CODIGO",OracleTypes.VARCHAR)
        );
        jdbcCall.withoutProcedureColumnMetaDataAccess();
        Map<String,Object> inParams = new HashMap<>();
        inParams.put("p_username",username);
        Map<String,Object> outParams = jdbcCall.execute(inParams);

        Integer codigo =outParams.get("OUT_CODIGO").equals("0000") ? 1 : 0;
        return codigo;
    }

    @Override
    public Map<String, Object> guardarToken(ConfirmationToken token) {
        String poolConnection = "rockjdbc";
        JdbcTemplate jdbcTemplate = context.getBean(poolConnection, JdbcTemplate.class);
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
        jdbcCall.withSchemaName(Constantes.SCHEMA);
        jdbcCall.withCatalogName(Constantes.CATALOG);
        jdbcCall.withProcedureName("sp_insup_confirmation_token");
        jdbcCall.declareParameters(
                new SqlParameter("p_token_id", OracleTypes.NUMBER),
                new SqlParameter("p_confirmed_at", OracleTypes.DATE),
                new SqlParameter("p_token", OracleTypes.VARCHAR),
                new SqlParameter("p_usu_id", OracleTypes.NUMBER),
                new SqlOutParameter("OUT_CODIGO",OracleTypes.VARCHAR),
                new SqlOutParameter("OUT_MSG",OracleTypes.VARCHAR)
        );

        jdbcCall.withoutProcedureColumnMetaDataAccess();
        Map<String,Object> inParams = new HashMap<>();
        inParams.put("p_token_id",token.getTokenId());
        inParams.put("p_confirmed_at",token.getConfirmedAt());
        inParams.put("p_token",token.getToken());
        inParams.put("p_usu_id",token.getUsuId());
        Map<String,Object> outParams = jdbcCall.execute(inParams);
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_CODIGO", outParams.get("OUT_CODIGO"));
        result.put("OUT_MSG", outParams.get("OUT_MSG"));
        return result;
    }

    @Override
    public ConfirmationToken getToken(String token) {

        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        ProcedureCall call = s.createStoredProcedureCall(Constantes.sp_check_token);//
//        call.registerParameter(1, String.class, ParameterMode.IN).enablePassingNulls(true);
//        call.setParameter(1, token);
//        call.registerParameter(2, String.class, ParameterMode.OUT);
//        call.registerParameter(3, String.class, ParameterMode.OUT);
//        call.execute();

        return null;
    }
}
