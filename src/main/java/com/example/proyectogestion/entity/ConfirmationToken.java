package com.example.proyectogestion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class ConfirmationToken {

    @JsonProperty("token_id")
    private BigDecimal tokenId;
    @JsonProperty("confirmed_at")
    private Timestamp confirmedAt;
    @JsonProperty("created_at")
    private Timestamp createdAt;
    @JsonProperty("expires_at")
    private Timestamp expiresAt;
    @JsonProperty("token")
    private String token;
    @JsonProperty("usu_id")
    private BigDecimal usuId;

}
