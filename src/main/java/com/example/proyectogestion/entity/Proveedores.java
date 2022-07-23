package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedores {
    @JsonProperty("proveedor_id")
    private BigDecimal proveedorId;
    @JsonProperty("ruc")
    private String ruc;

    public Proveedores(Object p){
        Object[] arr = (Object[]) p;
        this.proveedorId = (BigDecimal) arr[0];
        this.ruc = (String) arr[1];
    }
}
