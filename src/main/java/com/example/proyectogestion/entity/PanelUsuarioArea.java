package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanelUsuarioArea {

    @JsonProperty("panel_usuario_area_id")
    private BigDecimal panelUsuarioAreaId;
    @JsonProperty("usu_area_id")
    private BigDecimal usuAreaId;
    @JsonProperty("panel_id")
    private BigDecimal panelId;

    public PanelUsuarioArea(Object p){
        Object[] arr = (Object[]) p;
        this.panelUsuarioAreaId = (BigDecimal) arr[0];
        this.usuAreaId = (BigDecimal) arr[1];
        this.panelId = (BigDecimal) arr[2];
    }
}
