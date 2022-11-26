package com.api.semanatec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
@SecurityScheme(name = "bearerAuth"
				, description = "JWT Authorization header using the Bearer scheme"
				, scheme = "bearer"
				, bearerFormat = "JWT"
				, type = SecuritySchemeType.HTTP
				, in = SecuritySchemeIn.HEADER)
@SpringBootApplication
public class SemanatecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SemanatecApplication.class, args);
	}

}
