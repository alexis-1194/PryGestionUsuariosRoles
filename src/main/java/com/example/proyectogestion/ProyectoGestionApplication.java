package com.example.proyectogestion;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class ProyectoGestionApplication {

//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(ProyectoGestionApplication.class, args);
    }

}
