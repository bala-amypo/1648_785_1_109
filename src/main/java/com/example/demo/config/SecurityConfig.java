package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Disable CSRF for REST APIs (otherwise POST/PUT/DELETE return 403)
            .csrf(AbstractHttpConfigurer::disable)
            
            // 2. Set session to stateless for JWT
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            
            // 3. Configure Path Permissions
            .authorizeHttpRequests(auth -> auth
                // Allow the register and login endpoints
                .requestMatchers("/api/auth/**").permitAll()
                // Allow error path (crucial for Spring Security 6+ to see 400/500 errors instead of 403)
                .requestMatchers("/error").permitAll()
                // Allow Swagger/API Docs
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()
                // All other requests need a token
                .anyRequest().authenticated()
            );

        return http.build();
    }
}