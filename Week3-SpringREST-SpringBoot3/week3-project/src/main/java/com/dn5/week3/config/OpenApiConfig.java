package com.dn5.week3.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Module 7 -> "Documenting RESTful APIs" subtopic:
 * "Documenting REST APIs with Swagger/OpenAPI".
 * Visit /swagger-ui.html once the app is running to see this rendered.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI bookApiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Week 3 - Spring REST API (DN5.0)")
                        .description("Module 7 - Spring REST using Spring Boot 3: Book Management API")
                        .version("1.0.0"))
                .components(new Components().addSecuritySchemes("bearerAuth",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
