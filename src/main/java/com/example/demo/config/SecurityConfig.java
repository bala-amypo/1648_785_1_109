// // package com.example.demo.config;

// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// // import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// // import org.springframework.security.config.http.SessionCreationPolicy;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// // import org.springframework.security.web.SecurityFilterChain;

// // @Configuration
// // @EnableMethodSecurity
// // public class SecurityConfig {

// //     @Bean
// //     public PasswordEncoder passwordEncoder() {
// //         return new BCryptPasswordEncoder();
// //     }

// //     @Bean
// //     public AuthenticationManager authenticationManager(
// //             AuthenticationConfiguration config) throws Exception {
// //         return config.getAuthenticationManager();
// //     }

// //     @Bean
// //     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// //         http
// //             .csrf(AbstractHttpConfigurer::disable)
// //             .sessionManagement(session ->
// //                 session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
// //             )
// //             .authorizeHttpRequests(auth -> auth
// //                 .requestMatchers(
// //                     "/api/auth/**",
// //                     "/swagger-ui/**",
// //                     "/v3/api-docs/**",
// //                     "/swagger-resources/**",
// //                     "/webjars/**"
// //                 ).permitAll()
                
// //                 // ✅ ADDED: /api/recommendations/** to the permitted list
// //                 .requestMatchers(
// //                     "/api/users/**", 
// //                     "/cards/**", 
// //                     "/api/reward-rules/**",
// //                     "/api/intents/**",
// //                     "/api/recommendations/**"
// //                 ).permitAll()
                
// //                 .anyRequest().authenticated()
// //             );

// //         return http.build();
// //     }
// // }
// package com.example.demo.config;

// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         http
//             .csrf(csrf -> csrf.disable())
//             .sessionManagement(session ->
//                 session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//             )
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers(
//                     "/",
//                     "/error",
//                     "/auth/**",
//                     "/swagger-ui/**",
//                     "/swagger-ui.html",
//                     "/v3/api-docs/**"
//                 ).permitAll()
//                 .anyRequest().authenticated()
//             )
//             .exceptionHandling(ex -> ex
//                 .authenticationEntryPoint((request, response, authException) ->
//                         response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
//                 )
//             );

//         return http.build();
//     }
// }


package com.example.demo.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/",
                    "/error",
                    "/auth/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint((request, response, authException) ->
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
                )
            );

        return http.build();
    }
}
