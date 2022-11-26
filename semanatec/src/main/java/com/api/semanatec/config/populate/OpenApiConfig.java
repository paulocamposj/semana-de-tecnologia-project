package com.api.semanatec.config.populate;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

public class OpenApiConfig {
    private static final String API_TITLE = "SEMANA TEC API";
    private static final String API_DESCRIPTION = "Programa de frequência FICR";
    private static final String API_VERSION = "1.0.0";
    private static final String API_LICENSE = "Apache 2.0";
    private static final String API_LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0.html";
    private static final String CONTACT_NAME = "Backend Squad";
    private static final String CONTACT_GITLAB = "https://github.com/paulocamposj/semana-de-tecnologia-project";
    private static final String CONTACT_EMAIL = "admin@s.ficr.edu.br";

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(API_TITLE)
                        .version(API_VERSION)
                        .description(API_DESCRIPTION)
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name(API_LICENSE).url(API_LICENSE_URL))
                        .contact(new Contact()
                                .email(CONTACT_EMAIL)
                                .name(CONTACT_NAME)
                                .url(CONTACT_GITLAB)));
    }
}
