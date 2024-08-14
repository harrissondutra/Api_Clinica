package com.estudo.api_med_voll.configuration.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Clínica Médica Voll")
                        .version("v1")
                        .description("Documentação da API Clínica Médica")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("api")
                .packagesToScan("com.estudo.api_med_voll.controller")  // Ajuste o pacote base dos controllers
                .build();
    }

    @Bean
    public OpenApiCustomizer customizer() {
        return openApi -> {
            openApi.getComponents().getSchemas().remove("UnwantedModelName");  // Remover modelos indesejados
        };
    }
}


