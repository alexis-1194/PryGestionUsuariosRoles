package com.example.proyectogestion.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckTokenBean {
    private String token;
    private Timestamp confirmedAt;
}
