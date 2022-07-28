package com.example.proyectogestion.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserBean {

    @JsonProperty("apepat")
    private String apePat;
    @JsonProperty("apemat")
    private String apeMat;
    @JsonProperty("nombres")
    private String nombres;
    @JsonProperty("usuemail")
    private String usuEmail;
    @JsonProperty("pwd")
    private String usuPwd;

}
