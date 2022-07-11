package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class UsuarioPerfil {
    @JsonProperty("usu_id")
    private BigDecimal usuId;
    @JsonProperty("perfil_id")
    private BigDecimal perfilId;
    @JsonProperty("estado_usu_perfil")
    private Character estadoUsuPerfil;

}
