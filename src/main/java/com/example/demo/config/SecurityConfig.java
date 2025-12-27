package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationEntryPoint;
import com.example.demo.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; // Added this import
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // Added this annotation to enable Spring Security
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // 🔓 Public Auth & Swagger
                .requestMatchers(
                    "/auth/**",
                    "/swagger-ui/**",
                    "/v3/api-docs/**"
                ).permitAll()

                // 🔓 User Profiles (Added this to fix your 403 error)
                .requestMatchers("/api/users/**").permitAll()

                // 🔓 Products
                .requestMatchers(HttpMethod.POST, "/products").permitAll()
                .requestMatchers(HttpMethod.GET, "/products").permitAll()

                // 🔓 Warranties
                .requestMatchers(HttpMethod.POST, "/warranties/register/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/warranties/**").permitAll()

                // 🔓 Alert Logs
                .requestMatchers(HttpMethod.POST, "/logs/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/logs/**").permitAll()

                // 🔓 Alert Schedules
                .requestMatchers(HttpMethod.POST, "/schedules/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/schedules/**").permitAll()

                // 🔒 Everything else requires JWT
                .anyRequest().authenticated()
            )
            .exceptionHandling(ex -> 
                ex.authenticationEntryPoint(new JwtAuthenticationEntryPoint())
            )
            .addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}