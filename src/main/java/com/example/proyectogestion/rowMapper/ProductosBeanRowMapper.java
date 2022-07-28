package com.example.proyectogestion.rowMapper;

import com.example.proyectogestion.entity.Producto;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductosBeanRowMapper implements RowMapper<Producto> {

    @Override
    public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Producto producto = new Producto();
        producto.setProductoId(BigDecimal.valueOf(rs.getInt(1)));
        producto.setDesProducto(rs.getString(2));
        return producto;
    }
}
