package com.github.julioevencio.apiordermanagement.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI custoOpenAPI() {
		Info info = new Info()
				.title("API Order Management")
				.version("1.0")
				.description("An API for order management")
				.termsOfService("https://github.com/JulioEvencio/api-order-management/blob/main/LICENSE")
				.license(new License().name("MIT License").url("https://github.com/JulioEvencio/api-order-management/blob/main/LICENSE"));
		
		return new OpenAPI().info(info);
	}
	
}
