package com.example.proyectogestion.repository.impl;

import com.example.proyectogestion.repository.UsuRepoDetailService;
import com.example.proyectogestion.rowMapper.UsuarioMapper;
import com.example.proyectogestion.util.Constantes;
import lombok.RequiredArgsConstructor;
import oracle.jdbc.OracleTypes;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UsuRepoDetailServiceImpl implements UsuRepoDetailService {

    private final ApplicationContext context;

    @Override
    public Map<String, Object> getUsuarios(BigDecimal id) {
        String poolConnection = "rockjdbc";
        JdbcTemplate jdbcTemplate = context.getBean(poolConnection, JdbcTemplate.class);
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
        jdbcCall.withSchemaName(Constantes.SCHEMA);
        jdbcCall.withCatalogName(Constantes.CATALOG);
        jdbcCall.withProcedureName("sp_get_usuarios_like");
        jdbcCall.declareParameters(
                new SqlParameter("p_usu_area_id", OracleTypes.NUMBER),
                new SqlOutParameter("OUT_CODIGO",OracleTypes.VARCHAR),
                new SqlOutParameter("OUT_MSG",OracleTypes.VARCHAR),
                new SqlOutParameter("p_RefCursor",OracleTypes.CURSOR,new UsuarioMapper())
        );
        jdbcCall.withoutProcedureColumnMetaDataAccess();
        Map<String,Object> inParams = new HashMap<>();
        inParams.put("p_usu_area_id", id);
        SqlParameterSource in = new MapSqlParameterSource(inParams);
        Map<String,Object> execution = jdbcCall.execute(in);
        Map<String,Object> result = new HashMap<>();
        result.put("OUT_CODIGO",execution.get("OUT_CODIGO"));
        result.put("OUT_MSG",execution.get("OUT_MSG"));
        result.put("OUT_LIST",execution.get("p_RefCursor"));
        return result;
    }
}
