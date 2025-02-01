// filepath: /d:/Work_Space/Typescripts/Java-In-VS/springboot-in-vs-code/src/main/java/com/printers/config/SwaggerConfig.java
package com.printers.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Worker API")
                        .version("1.0")
                        .description("API documentation for Worker Service"));
    }
}