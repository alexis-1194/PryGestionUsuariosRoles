package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class UsuarioPerfil {
    private BigDecimal idUsuPerfil;
    @JsonProperty("usu_perfil_estado")
    private Character usuPerfilEstado;
    private BigDecimal usuAreaId;
    private BigDecimal perfilId;
    private BigDecimal rolId;

}
