package com.example.proyectogestion.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class ConfiguraDataBase {

    @Value("${spring.server.driver-class-name}")
    private String driver;

    @Value("${spring.server.username}")
    private String username;

    @Value("${spring.server.password}")
    private String password;

    @Value("${spring.jdbc-url.desalima}")
    private String desalima;

    //Creamos el Bean
    @Bean(name = "dslima")
    @Primary
    public DataSource desaLimaDataSource() {
        HikariDataSource dataSource = null;
        HikariConfig config = new HikariConfig();
        try {
            config.setDriverClassName(driver);
            config.setUsername(username);
            config.setPassword(password);
            config.setJdbcUrl(desalima);
            config.setPoolName("DATASOURCE-LIMA");
            dataSource = new HikariDataSource(config);
        } catch (Exception e) {
            log.error("Error al crear el datasource: {}", e.getMessage());
        }
        return dataSource;
    }

    @Bean(name = {"rockjdbc"})
    @Autowired
    public JdbcTemplate limaJdbcTemplate(@Qualifier("dslima") DataSource ds) {
        JdbcTemplate jdbcTemplate = null;
        try {
            if (ds != null) {
                jdbcTemplate = new JdbcTemplate(ds);
            }
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
        return jdbcTemplate;
    }

//    private String decodeJCE(String encoded) {
//        try {
//            return KryptoHelper.getInstance().decrypt(KryptoHelper.DEFAULT_KEY, encoded);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}
