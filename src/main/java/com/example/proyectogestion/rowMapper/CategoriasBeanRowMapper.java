package com.example.proyectogestion.rowMapper;

import com.example.proyectogestion.entity.Categoria;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriasBeanRowMapper implements RowMapper<Categoria> {
    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        Categoria cat = new Categoria();
        cat.setCategoriaId(BigDecimal.valueOf(rs.getInt(1)));
        cat.setCategoriaDes(rs.getString(2));
        return cat;
    }
}
