package com.mesutsaritas.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mesutsaritas.handler.UserHandler;

/**
 * @author msaritas
 *
 */

@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> usersRoute(UserHandler userHandler) {
        return RouterFunctions.route(GET("/users").and(accept(MediaType.APPLICATION_JSON)), userHandler::list)
                .andRoute(POST("/users").and(accept(MediaType.APPLICATION_JSON)), userHandler::create)
                .andRoute(GET("/users/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::load)
                .andRoute(DELETE("/users/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::remove);
    }

}
