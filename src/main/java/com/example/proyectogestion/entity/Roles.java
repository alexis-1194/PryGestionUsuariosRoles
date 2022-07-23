package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor@AllArgsConstructor
public class Roles {
    @JsonProperty("rol_id")
    private BigDecimal rolId;
    @JsonProperty("rol_des")
    private String rolDes;
    @JsonProperty("rol_estado")
    private String rolEstado;

    public Roles(Object p){
        Object[] arr = (Object[]) p;
        this.rolId = (BigDecimal) arr[0];
        this.rolDes = (String) arr[1];
        this.rolEstado = (String) arr[2];
    }
}
