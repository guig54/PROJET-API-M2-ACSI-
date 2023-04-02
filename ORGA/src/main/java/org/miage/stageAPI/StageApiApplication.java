package org.miage.stageAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class StageApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StageApiApplication.class, args);
	}

	@Bean
	public OpenAPI StageApi() {
		return new OpenAPI().info(new Info()
				.title("Stage API")
				.version("1.0")
				.description("Documentation de l'API"));
	}


}