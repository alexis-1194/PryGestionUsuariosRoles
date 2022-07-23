package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Usuario {

    @JsonProperty("usu_id")
    private BigDecimal usuId;
    @JsonProperty("persona_id")
    private BigDecimal personaId;
    @JsonProperty("usu_email")
    private String usuEmail;
    @JsonProperty("habilitado")
    private Character habilitado;
    @JsonProperty("estado")
    private Character estado;
    @JsonProperty("usu_pwd")
    private String usuPwd;

}
