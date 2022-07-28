package com.example.proyectogestion.repository;

import java.math.BigDecimal;
import java.util.Map;

public interface UsuRepoDetailService {

    Map<String,Object> getUsuarios(BigDecimal id);
}
