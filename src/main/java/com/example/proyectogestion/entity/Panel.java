package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Panel {
    @JsonProperty("panel_id")
    private BigDecimal panelId;
    @JsonProperty("panel_des")
    private String panelDes;
    @JsonProperty("panel_estado")
    private Character panelEstado;

}
