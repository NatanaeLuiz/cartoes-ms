package com.cartoesms.cartoes_ms.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {

    private String driverClassName;
    private String url;

    @Profile("dev")
    @Bean
    public String testDatabaseConnection() {
        System.out.println("::: DB Connection for DEV - H2 :::");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to H2_TEST - Test Instance";
    }

    @Profile("prod")
    @Bean
    public String productionDatabaseConnection() {
        System.out.println("::: DB Connection for Production - PostgreSQL :::");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to PostgreSQL_PROD - Production Instance";
    }
}