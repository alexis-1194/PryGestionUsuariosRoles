package com.example.proyectogestion.rowMapper;

import com.example.proyectogestion.entity.Proveedores;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProveedoresBeanRowMapper implements RowMapper<Proveedores> {

    @Override
    public Proveedores mapRow(ResultSet rs, int rowNum) throws SQLException {
        Proveedores proveedores = new Proveedores();
        proveedores.setProveedorId(rs.getBigDecimal(1));
        proveedores.setRuc(rs.getString(2));
        return proveedores;
    }
}
