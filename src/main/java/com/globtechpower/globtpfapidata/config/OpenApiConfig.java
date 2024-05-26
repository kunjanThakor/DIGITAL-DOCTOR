package com.globtechpower.globtpfapidata.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

   @Bean
    public OpenApiCustomizer customizeOpenApi() {
        return openApi -> openApi.info(new Info()
            .title("GLOBTPF API")
            .description("API for globtpf")
            .version("1.0.0")
            .contact(new io.swagger.v3.oas.models.info.Contact()
                .name("GLOBTPF-DEVS")
                .url("/")
                .email("kunjan7634@gmail.com"))
            );
    }
}
