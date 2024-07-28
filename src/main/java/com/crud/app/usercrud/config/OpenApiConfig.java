package com.crud.app.usercrud.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Simple User API with Crud Operations")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Aysun Ahmedov")
                                .email("icehack@abv.bg"))
                        .description("This is a web REST API application using the standard HTTP methods – GET, POST, PUT, DELETE . It is built with Spring Boot with Maven and uses a MySQL database."));
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
