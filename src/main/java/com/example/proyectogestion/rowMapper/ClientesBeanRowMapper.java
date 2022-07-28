package com.example.proyectogestion.rowMapper;

import com.example.proyectogestion.entity.Cliente;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesBeanRowMapper implements RowMapper<Cliente> {

    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cliente cli = new Cliente();
        cli.setClienteId(BigDecimal.valueOf(rs.getInt("CLIENTE_ID")));
        cli.setNombres(rs.getString("NOMBRES"));

        return cli;
    }
}
