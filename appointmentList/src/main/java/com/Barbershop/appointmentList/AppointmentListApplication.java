package com.Barbershop.appointmentList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class AppointmentListApplication {

	@Bean
	public OpenAPI apiInfo() {
		return new OpenAPI()
				.info(new Info()
						.title("Barbershop Appointment API")
						.description("API for managing barbershop appointments")
						.version("1.0.0"));
	}

	public static void main(String[] args) {
		SpringApplication.run(AppointmentListApplication.class, args);
	}
}