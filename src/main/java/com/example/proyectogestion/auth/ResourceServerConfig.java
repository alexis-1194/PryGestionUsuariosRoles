package com.example.proyectogestion.auth;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
//@EnableResourceServer
//extends ResourceServerConfigurerAdapter
public class ResourceServerConfig  {

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests().antMatchers("/usuarios/registrar").permitAll()
//                .anyRequest().authenticated()
//                .and().cors().configurationSource(corsConfigurationSource());
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//        config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
//        config.setAllowCredentials(true);
//        config.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//        return source;
//    }
//
//    @Bean
//    public FilterRegistrationBean<CorsFilter> corsFilter(){
//        FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
//        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return filter;
//    }
}
