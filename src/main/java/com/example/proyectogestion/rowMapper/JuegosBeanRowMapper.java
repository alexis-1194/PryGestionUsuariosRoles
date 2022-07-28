package com.example.proyectogestion.rowMapper;

import com.example.proyectogestion.entity.Juegos;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JuegosBeanRowMapper implements RowMapper<Juegos> {

    @Override
    public Juegos mapRow(ResultSet rs, int rowNum) throws SQLException {
        Juegos juegos = new Juegos();
        juegos.setJuegoId(BigDecimal.valueOf(rs.getInt(1)));
        juegos.setJuegoDes(rs.getString(2));
        return juegos;
    }
}
