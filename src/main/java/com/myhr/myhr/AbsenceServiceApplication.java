package com.myhr.myhr;

import com.myhr.myhr.handler.AbsenceHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@SpringBootApplication
public class AbsenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbsenceServiceApplication.class, args);
	}

	@Bean
	RouterFunction<?> router(final AbsenceHandler absenceHandler) {
		//return route(GET("/absences/{organizationId}/{userId}"), absenceHandler::getAllForUser);
		return nest(path("/absences"),
				route(GET("/{organizationId}"), absenceHandler::getAllForOrganization)
				.andRoute(GET("/{organizationId}/{userId}"), absenceHandler::getAllForUser)
		);
	}
}
