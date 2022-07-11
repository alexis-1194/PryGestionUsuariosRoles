package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Categoria {

    @JsonProperty("categoria_id")
    private BigDecimal categoriaId;
    @JsonProperty("categoria_des")
    private BigDecimal categoriaDes;

}
