package org.openapitools

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.security.SecurityScheme

@Configuration
class SpringDocConfiguration {

    @Bean
    fun apiInfo(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Comuam")
                    .description("Correo de contacto del API")
                    .contact(
                        Contact()
                            .name("Proyect Almanac")
                            .url("https://ProjektAlmanac.github.io")
                            .email("miguel.gzm98@gmail.com")
                    )
                    .license(
                        License()
                            .name("MIT")
                            .url("https://proyektalmanac.github.io/license")
                    )
                    .version("1.0")
            )
            .components(
                Components()
                    .addSecuritySchemes("jwt", SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                    )
            )
    }
}
