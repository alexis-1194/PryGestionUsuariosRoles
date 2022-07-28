package com.example.proyectogestion.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AreasUsuarioBean {

    private BigDecimal USU_AREA_ID;
    private String PERSONA;
    private BigDecimal AREA_ID;
    private String AREA_ABREV;
    private String AREA_DES;

}
