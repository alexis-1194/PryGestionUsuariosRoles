package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanelArea {
    @JsonProperty("panel_area_id")
    private BigDecimal panelAreaId;
    @JsonProperty("panel_id")
    private BigDecimal panelId;
    @JsonProperty("area_id")
    private BigDecimal areaId;

    public PanelArea(Object p){
        Object[] arr = (Object[]) p;
        this.panelAreaId = (BigDecimal) arr[0];
        this.panelId = (BigDecimal) arr[1];
        this.areaId = (BigDecimal) arr[2];
    }
}
