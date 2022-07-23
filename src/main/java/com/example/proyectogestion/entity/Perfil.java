package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Perfil {

    @JsonProperty("perfil_id")
    private BigDecimal perfilId;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("perfil_estado")
    private Character perfilEstado;

}
