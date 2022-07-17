package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @JsonProperty("cliente_id")
    private BigDecimal clienteId;
    @JsonProperty("nombres")
    private String nombres;

    public Cliente(Object p){
        Object[] arr = (Object[]) p;
        this.clienteId = (BigDecimal) arr[0];
        this.nombres = (String) arr[1];
    }

}
