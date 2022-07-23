package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Juegos {
    @JsonProperty("juego_id")
    private BigDecimal juegoId;

    @JsonProperty("juego_des")
    private String juegoDes;

    public Juegos(Object p){
        Object[] arr = (Object[]) p;
        this.juegoId = (BigDecimal) arr[0];
        this.juegoDes = (String) arr[1];
    }
}
