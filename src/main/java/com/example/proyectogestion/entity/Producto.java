package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Producto {

    @JsonProperty("producto_id")
    private BigDecimal productoId;
    @JsonProperty("des_producto")
    private String DesProducto;

}
