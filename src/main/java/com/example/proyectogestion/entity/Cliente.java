package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Cliente {

    @JsonProperty("cliente_id")
    private BigDecimal clienteId;
    @JsonProperty("nombres_apellidos")
    private String nombresApellidos;
}
