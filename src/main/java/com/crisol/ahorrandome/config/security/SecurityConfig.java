package com.crisol.ahorrandome.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desactiva CSRF (solo en desarrollo)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/gastos_diarios/v1/api/users/**").permitAll() // acceso libre a /users
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults()); // habilita auth básica (usuario/contraseña en encabezado)

        return http.build();
    }
}
