package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Area {

    @JsonProperty("perfil_id")
    private BigDecimal areaId;
    @JsonProperty("area_des")
    private String areaDes;
    @JsonProperty("area_abrev")
    private String areaAbrev;
    @JsonProperty("area_estado")
    private Character areaEstado;

}
