package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @JsonProperty("producto_id")
    private BigDecimal productoId;
    @JsonProperty("des_producto")
    private String DesProducto;

    public Producto(Object p){
        Object[] arr = (Object[]) p;
        this.productoId = (BigDecimal) arr[0];
        this.DesProducto = (String) arr[1];
    }

}
