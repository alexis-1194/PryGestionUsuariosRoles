package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PanelPerfil {

    @JsonProperty("vista_id")
    private BigDecimal vistaId;
    @JsonProperty("perfil_id")
    private BigDecimal perfilId;

}
