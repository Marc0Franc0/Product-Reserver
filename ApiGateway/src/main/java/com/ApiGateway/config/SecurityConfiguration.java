package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain filter(ServerHttpSecurity httpSecurity) {
         return httpSecurity
                 .csrf(csrf->csrf.disable())
                 .authorizeExchange(exchange ->exchange.anyExchange().authenticated())
                 .oauth2Login(Customizer.withDefaults())
                 .build();

    }

}
