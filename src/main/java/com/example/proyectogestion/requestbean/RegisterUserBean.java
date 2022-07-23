package com.example.proyectogestion.requestbean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserBean {

    private String apePat;
    private String apeMat;
    private String nombres;
    private String usuEmail;
    private String usuPwd;

}
