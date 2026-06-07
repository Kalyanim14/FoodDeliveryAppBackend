package com.example.fooddelivery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                // Public APIs
                .requestMatchers(
                        "/api/users/register",
                        "/api/users/login")
                .permitAll()

                .requestMatchers(
                        HttpMethod.GET,
                        "/api/restaurants/**")
                .permitAll()

                // ADMIN only
                .requestMatchers(
                        HttpMethod.POST,
                        "/api/restaurants/**")
                .hasRole("ADMIN")

                .requestMatchers(
                        HttpMethod.PUT,
                        "/api/restaurants/**")
                .hasRole("ADMIN")

                .requestMatchers(
                        HttpMethod.DELETE,
                        "/api/restaurants/**")
                .hasRole("ADMIN")

                // CUSTOMER only
                .requestMatchers("/api/cart/**")
                .hasRole("CUSTOMER")

                .requestMatchers("/api/orders/**")
                .hasAnyRole("CUSTOMER", "ADMIN")

                .anyRequest()
                .authenticated()
            )

            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}