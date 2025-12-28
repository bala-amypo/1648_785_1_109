// // package com.example.demo.config;

// // import io.swagger.v3.oas.models.Components;
// // import io.swagger.v3.oas.models.OpenAPI;
// // import io.swagger.v3.oas.models.info.Info;
// // import io.swagger.v3.oas.models.security.SecurityRequirement;
// // import io.swagger.v3.oas.models.security.SecurityScheme;
// // import io.swagger.v3.oas.models.servers.Server;
// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// // import java.util.List;

// // @Configuration
// // public class SwaggerConfig {

// //     @Bean
// //     public OpenAPI customOpenAPI() {
// //         final String securitySchemeName = "bearerAuth";
// //         return new OpenAPI()
// //                 .info(new Info()
// //                         .title("User Profile API")
// //                         .version("1.0")
// //                         .description("API for managing user profiles. Use the /api/auth/login endpoint to get a token."))
// //                 .servers(List.of(
// //                         new Server().url("https://9173.pro604cr.amypo.ai/").description("Development Server")
// //                 ))
// //                 // This applies security to EVERY endpoint in the UI
// //                 .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
// //                 .components(new Components()
// //                         .addSecuritySchemes(securitySchemeName, new SecurityScheme()
// //                                 .name(securitySchemeName)
// //                                 .type(SecurityScheme.Type.HTTP)
// //                                 .scheme("bearer")
// //                                 .bearerFormat("JWT")
// //                                 .in(SecurityScheme.In.HEADER))); // Ensures token is sent in Header
// //     }
// // }

// package com.example.demo.config;

// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
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
//                 .authenticationEntryPoint(
//                     (request, response, authException) ->
//                         response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
//                                 "Unauthorized")
//                 )
//             );

//         return http.build();
//     }
// }

package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("Credit Card Reward Maximizer API")
                        .version("1.0")
                        .description("Use /auth/login to obtain JWT token"))
                .servers(List.of(
                        new Server().url("https://9173.pro604cr.amypo.ai").description("Server")
                ))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .in(SecurityScheme.In.HEADER)
                        ));
    }
}
