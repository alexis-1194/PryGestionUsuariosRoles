package com.example.proyectogestion.rowMapper;

import com.example.proyectogestion.bean.UsuarioBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<UsuarioBean> {

    @Override
    public UsuarioBean mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsuarioBean usuarioBean = new UsuarioBean();
        usuarioBean.setUsername(rs.getString(1));
        usuarioBean.setPwd(rs.getString(2));
        usuarioBean.setEstado(rs.getString(3).charAt(0));
        usuarioBean.setRol(rs.getString(4));

        return usuarioBean;
    }
}
