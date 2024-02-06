package com.hotelbooking.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@SecurityScheme(name = "Authorization", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER, bearerFormat = "Bearer {token}")

//SETTING UP THE SWAGGER TO WORK WITH API
public class SwaggerConfig {
	@Bean
	GroupedOpenApi openapi() {
		return GroupedOpenApi.builder().group("Hotel Booking MVP").displayName("Hotel Booking MVP")
				.pathsToMatch().packagesToScan("com.hotelbooking").build();
	}

	@Bean
	OpenAPI api() {
		return new OpenAPI().info(new Info().title("Hotel Booking MVP")
				.description("Hotel Booking MVP is used to book the hotel and get the hotel details for the booking")
				.contact(new Contact()).title("Hotel Booking MVP").version("1.0"));
	}

}