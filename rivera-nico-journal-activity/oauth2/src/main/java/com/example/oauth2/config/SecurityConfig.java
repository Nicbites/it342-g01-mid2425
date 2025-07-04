package com.example.oauth2.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorizeRequest-> authorizeRequest.anyRequest().authenticated())
                .formLogin(form -> form.defaultSuccessUrl("/secured", true))
                .oauth2Login(oauth -> oauth.defaultSuccessUrl("/secured", true))
                .build();
    }
}