package com.example.proyectogestion.rowMapper;

import com.example.proyectogestion.entity.Almacen;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlmacenBeanRowMapper implements RowMapper<Almacen> {

    @Override
    public Almacen mapRow(ResultSet rs, int rowNum) throws SQLException {
        Almacen almacen = new Almacen();
        almacen.setAlmacenId(rs.getBigDecimal(1));
        almacen.setAlmacenDes(rs.getString(2));
        return almacen;
    }
}
