package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Almacen {
    @JsonProperty("almacen_id")
    private BigDecimal almacenId;

    @JsonProperty("almacen_des")
    private String almacenDes;

    public Almacen(Object p){
        Object[] arr = (Object[]) p;
        this.almacenId = (BigDecimal) arr[0];
        this.almacenDes = (String) arr[1];
    }
}
