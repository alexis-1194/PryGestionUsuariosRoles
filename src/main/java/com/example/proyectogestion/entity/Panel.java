package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Panel {
    @JsonProperty("vista_id")
    private BigDecimal vistaId;
    @JsonProperty("vista_des")
    private String vistaDes;
    @JsonProperty("vista_estado")
    private Character vistaEstado;

}
