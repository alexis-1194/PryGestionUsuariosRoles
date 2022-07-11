package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UsuarioArea {
    @JsonProperty("usu_area_id")
    private BigDecimal usuAreaId;
    @JsonProperty("usu_area_est")
    private Character usuAreaEst;
    @JsonProperty("usu_area_fec_reg")
    private Timestamp usuAreaFecReg;
    @JsonProperty("area_id")
    private BigDecimal areaId;
    @JsonProperty("usu_id")
    private BigDecimal usuId;

}
