package com.example.proyectogestion.rowMapper;

import com.example.proyectogestion.bean.AreasUsuarioBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreasUsuarioBeanRowMapper implements RowMapper<AreasUsuarioBean> {
    @Override
    public AreasUsuarioBean mapRow(ResultSet rs, int rowNum) throws SQLException {
        AreasUsuarioBean areasUsuarioBean = new AreasUsuarioBean();
        areasUsuarioBean.setUSU_AREA_ID(rs.getBigDecimal(1));
        areasUsuarioBean.setPERSONA(rs.getString(2));
        areasUsuarioBean.setAREA_ID(rs.getBigDecimal(3));
        areasUsuarioBean.setAREA_ABREV(rs.getString(4));
        areasUsuarioBean.setAREA_DES(rs.getString(5));
        return areasUsuarioBean;
    }
}
