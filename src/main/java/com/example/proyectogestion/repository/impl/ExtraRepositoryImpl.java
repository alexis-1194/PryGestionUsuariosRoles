package com.example.proyectogestion.repository.impl;

import com.example.proyectogestion.entity.Categoria;
import com.example.proyectogestion.entity.Cliente;
import com.example.proyectogestion.repository.ExtraRepository;
import com.example.proyectogestion.rowMapper.*;
import com.example.proyectogestion.util.Constantes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleTypes;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ExtraRepositoryImpl implements ExtraRepository {

    //cambios para no usar jpa
    private final ApplicationContext context;


    @Override
    public Map<String, Object> getCategorias(Integer p_limit) {
        log.info("p_limit: {}", p_limit);
        String poolConnection = "rockjdbc";
        JdbcTemplate jdbcTemplate = context.getBean(poolConnection, JdbcTemplate.class);
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
        call.withSchemaName(Constantes.SCHEMA);
        call.withCatalogName(Constantes.CATALOG);
        call.withProcedureName("SP_LIST_CATEGORIAS");
        call.declareParameters(
                new SqlParameter("p_limit", OracleTypes.NUMBER),
                new SqlOutParameter("OUT_CODIGO", OracleTypes.VARCHAR),
                new SqlOutParameter("OUT_MSG", OracleTypes.VARCHAR),
                new SqlOutParameter("p_total", OracleTypes.NUMBER),
                new SqlOutParameter("p_Cursor", OracleTypes.CURSOR, new CategoriasBeanRowMapper())
        );
        call.withoutProcedureColumnMetaDataAccess();
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_limit", p_limit);
        SqlParameterSource in = new MapSqlParameterSource(inParams);
        Map<String, Object> result = call.execute(in);
        Map<String, Object> response = new HashMap<>();
        response.put("OUT_CODIGO", result.get("OUT_CODIGO"));
        response.put("OUT_MSG", result.get("OUT_MSG"));
        response.put("OUT_CANTIDAD", result.get("p_total"));
        List<Categoria> categorias = (List) result.get("p_Cursor");
        response.put("OUT_CURSOR", categorias);

        return response;
    }

    @Override
    public Map<String, Object> getProductos(Integer p_limit) {
        log.info("p_limit: {}", p_limit);
        String poolConnection = "rockjdbc";
        JdbcTemplate jdbcTemplate = context.getBean(poolConnection, JdbcTemplate.class);
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
        jdbcCall.withSchemaName(Constantes.SCHEMA);
        jdbcCall.withCatalogName(Constantes.CATALOG);
        jdbcCall.withProcedureName("SP_LIST_PRODUCTOS");
        jdbcCall.declareParameters(
                new SqlParameter("p_limit",OracleTypes.NUMBER),
                new SqlOutParameter("OUT_CODIGO",OracleTypes.VARCHAR),
                new SqlOutParameter("OUT_MSG",OracleTypes.VARCHAR),
                new SqlOutParameter("p_total",OracleTypes.NUMBER),
                new SqlOutParameter("p_Cursor",OracleTypes.CURSOR,new ProductosBeanRowMapper())
        );
        jdbcCall.withoutProcedureColumnMetaDataAccess();
        Map<String,Object> inParams = new HashMap<>();
        inParams.put("p_limit",p_limit);
        SqlParameterSource in = new MapSqlParameterSource(inParams);
        Map<String,Object> execution = jdbcCall.execute(in);
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_CODIGO",execution.get("OUT_CODIGO"));
        result.put("OUT_MSG",execution.get("OUT_MSG"));
        result.put("OUT_CANTIDAD",execution.get("p_total"));
        result.put("OUT_LIST",execution.get("p_Cursor"));
        return result;
    }

    @Override
    public Map<String, Object> getJuegos(Integer p_limit) {
        log.info("p_limit: {}", p_limit);
        String poolConnection = "rockjdbc";
        JdbcTemplate jdbcTemplate = context.getBean(poolConnection,JdbcTemplate.class);
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
        jdbcCall.withSchemaName(Constantes.SCHEMA);
        jdbcCall.withCatalogName(Constantes.CATALOG);
        jdbcCall.withProcedureName("SP_LIST_JUEGOS");
        jdbcCall.declareParameters(
                new SqlParameter("p_limit",OracleTypes.NUMBER),
                new SqlOutParameter("OUT_CODIGO",OracleTypes.VARCHAR),
                new SqlOutParameter("OUT_MSG",OracleTypes.VARCHAR),
                new SqlOutParameter("p_total",OracleTypes.NUMBER),
                new SqlOutParameter("p_Cursor",OracleTypes.CURSOR,new JuegosBeanRowMapper())
        );
        jdbcCall.withoutProcedureColumnMetaDataAccess();
        Map<String,Object> inParams = new HashMap<>();
        inParams.put("p_limit",p_limit);
        SqlParameterSource in = new MapSqlParameterSource(inParams);
        Map<String,Object> execution = jdbcCall.execute(in);
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_CODIGO", execution.get("OUT_CODIGO"));
        result.put("OUT_MSG", execution.get("OUT_MSG"));
        result.put("OUT_CANTIDAD", execution.get("p_total"));
        result.put("OUT_LIST", execution.get("p_Cursor"));
        return result;
    }

    @Override
    public Map<String, Object> getAlmacen(Integer p_limit) {
        log.info("p_limit: {}", p_limit);
        String poolConnection = "rockjdbc";
        JdbcTemplate jdbcTemplate = context.getBean(poolConnection,JdbcTemplate.class);
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
        jdbcCall.withSchemaName(Constantes.SCHEMA);
        jdbcCall.withCatalogName(Constantes.CATALOG);
        jdbcCall.withProcedureName("SP_LIST_ALMACEN");
        jdbcCall.declareParameters(
                new SqlParameter("p_limit",OracleTypes.NUMBER),
                new SqlOutParameter("OUT_CODIGO",OracleTypes.VARCHAR),
                new SqlOutParameter("OUT_MSG",OracleTypes.VARCHAR),
                new SqlOutParameter("p_total",OracleTypes.NUMBER),
                new SqlOutParameter("p_Cursor",OracleTypes.CURSOR,new AlmacenBeanRowMapper())
        );
        jdbcCall.withoutProcedureColumnMetaDataAccess();
        Map<String,Object> inParams = new HashMap<>();
        inParams.put("p_limit",p_limit);
        SqlParameterSource in = new MapSqlParameterSource(inParams);
        Map<String,Object> execution = jdbcCall.execute(in);
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_CODIGO", execution.get("OUT_CODIGO"));
        result.put("OUT_MSG", execution.get("OUT_MSG"));
        result.put("OUT_CANTIDAD", execution.get("p_total"));
        result.put("OUT_LIST", execution.get("p_Cursor"));
        return result;
    }

    @Override
    public Map<String, Object> getProveedores(Integer p_limit) {

        String poolConnection = "rockjdbc";
        JdbcTemplate jdbcTemplate = context.getBean(poolConnection,JdbcTemplate.class);
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
        jdbcCall.withSchemaName(Constantes.SCHEMA);
        jdbcCall.withCatalogName(Constantes.CATALOG);
        jdbcCall.withProcedureName("SP_LIST_PROVEEDORES");
        jdbcCall.declareParameters(
                new SqlParameter("p_limit",OracleTypes.NUMBER),
                new SqlOutParameter("OUT_CODIGO",OracleTypes.VARCHAR),
                new SqlOutParameter("OUT_MSG",OracleTypes.VARCHAR),
                new SqlOutParameter("p_total",OracleTypes.NUMBER),
                new SqlOutParameter("p_Cursor",OracleTypes.CURSOR,new ProveedoresBeanRowMapper())
        );
        jdbcCall.withoutProcedureColumnMetaDataAccess();
        Map<String,Object> inParams = new HashMap<>();
        inParams.put("p_limit",p_limit);
        SqlParameterSource in = new MapSqlParameterSource(inParams);
        Map<String,Object> execution = jdbcCall.execute(in);
        Map<String, Object> result = new HashMap<>();
        result.put("OUT_CODIGO", execution.get("OUT_CODIGO"));
        result.put("OUT_MSG", execution.get("OUT_MSG"));
        result.put("OUT_CANTIDAD", execution.get("p_total"));
        result.put("OUT_LIST", execution.get("p_Cursor"));
        return result;
    }

    @Override
    public Map<String, Object> getClientesV2(Integer p_limit) {
        String jdbcPool = "rockjdbc";

        JdbcTemplate jdbcTemplate = context.getBean(jdbcPool, JdbcTemplate.class);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
        jdbcCall.withSchemaName(Constantes.SCHEMA);
        jdbcCall.withCatalogName(Constantes.CATALOG);
        jdbcCall.withProcedureName("SP_LIST_CLIENTES");
        jdbcCall.declareParameters(
                new SqlParameter("p_limit", OracleTypes.NUMBER),
                new SqlOutParameter("OUT_CODIGO", OracleTypes.VARCHAR),
                new SqlOutParameter("OUT_MSG", OracleTypes.VARCHAR),
                new SqlOutParameter("p_total", OracleTypes.NUMBER),
                new SqlOutParameter("p_Cursor", OracleTypes.CURSOR, new ClientesBeanRowMapper())
        );
        jdbcCall.withoutProcedureColumnMetaDataAccess();
        Map<String, Object> inParam = new HashMap<>();
        inParam.put("p_limit", p_limit);
        SqlParameterSource in = new MapSqlParameterSource(inParam);
        Map<String, Object> result = jdbcCall.execute(in);
        Map<String, Object> response = new HashMap<>();
        response.put("OUT_CODIGO", result.get("OUT_CODIGO"));
        response.put("OUT_MSG", result.get("OUT_MSG"));
        response.put("OUT_CANTIDAD", result.get("p_total"));
        List<Cliente> list = (List) result.get("p_Cursor");
        response.put("OUT_LIST", list);

        System.out.println("PAUSA PARA VER LOS DATOS");
        return response;
    }
}
