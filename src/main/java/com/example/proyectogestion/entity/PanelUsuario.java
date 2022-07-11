package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PanelUsuario {

    @JsonProperty("vista_id")
    private BigDecimal vistaId;
    @JsonProperty("usu_id")
    private BigDecimal usuId;

}
