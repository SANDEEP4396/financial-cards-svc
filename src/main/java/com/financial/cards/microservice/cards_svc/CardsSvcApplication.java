package com.financial.cards.microservice.cards_svc;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API Documentation",
				description = "Cards microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Test User",
						email = "test@CardsSvc.com",
						url = "https://www.CardsSvc.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.CardsSvc.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Cards microservice REST API Documentation",
				url = "https://www.CardsSvc.com/swagger-ui.html"
		)
)
public class CardsSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsSvcApplication.class, args);
	}

}
