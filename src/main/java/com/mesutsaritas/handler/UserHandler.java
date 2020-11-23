package com.mesutsaritas.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mesutsaritas.model.User;
import com.mesutsaritas.resource.UserResource;
import com.mesutsaritas.service.UserService;

import reactor.core.publisher.Mono;

/**
 * @author msaritas
 *
 */

@Component
public class UserHandler {

    private final UserService userService;

    @Autowired
    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    /**
     * 
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> list(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userService.list(), User.class);

    }

    /**
     * 
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> load(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userService.load(Long.parseLong(id)), User.class);
    }

    /**
     * 
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        Mono<UserResource> insertToUser = serverRequest.bodyToMono(UserResource.class);
        return insertToUser.flatMap(
                user -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userService.create(user), User.class));

    }

    /**
     * 
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> remove(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<Void> deleteUser = userService.remove(Long.parseLong(id));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(deleteUser, Void.class);
    }

}
