package com.AlexRozhkovan.demospingboot_snsz.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI supplierOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Supplier API")
                        .description(" Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
    }
}
