package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data@AllArgsConstructor@NoArgsConstructor
public class Persona {
    @JsonProperty("persona_id")
    private BigDecimal personaId;
    @JsonProperty("apepat")
    private String apePat;
    @JsonProperty("apemat")
    private String apeMat;
    @JsonProperty("nombres")
    private String nombres;

    public Persona(Object p){
        Object[] arr = (Object[]) p;
        this.personaId = (BigDecimal) arr[0];
        this.apePat = (String) arr[1];
        this.apeMat = (String) arr[2];
        this.nombres = (String) arr[3];
    }

}
