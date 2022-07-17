package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @JsonProperty("categoria_id")
    private BigDecimal categoriaId;
    @JsonProperty("categoria_des")
    private BigDecimal categoriaDes;

    public Categoria (Object p){
        Object[] arr = (Object[]) p;
        this.categoriaId = (BigDecimal) arr[0];
        this.categoriaDes = (BigDecimal) arr[1];
    }

}
