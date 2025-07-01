package cl.java.dbd.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Dead By Daylight")
                        .version("1.0.0")
                        .description("Documentación de la API para Dead By Daylight.")
                        .contact(new Contact()
                                .name("Martín Villarroel")
                                .email("martin@duocuc.cl")
                                .url("https://deadbydaylight.com")
                        )
                        .license(new License()
                                .name("Licencia Dead By Daylight")
                                .url("https.//opensource.org/lecences/MIT")

                        )
                );
    }
}