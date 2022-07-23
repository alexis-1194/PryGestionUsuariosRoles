package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data@NoArgsConstructor@AllArgsConstructor
public class PanelUsuarioPerfil {
    @JsonProperty("panel_usu_perfil_id")
    private BigDecimal panelUsuarioPerfilId;
    @JsonProperty("idi_usu_perfil")
    private BigDecimal idUsuPerfil;
    @JsonProperty("panel_id")
    private BigDecimal panelId;
}
