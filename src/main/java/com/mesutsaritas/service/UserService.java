package com.mesutsaritas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mesutsaritas.model.User;
import com.mesutsaritas.repository.UserRepository;
import com.mesutsaritas.resource.UserResource;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author msaritas
 *
 */
@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 
     * @return
     */
    public Flux<User> list() {
        return userRepository.findAll();
    }

    /**
     * 
     * @return
     */
    public Mono<User> load(Long id) {
        return userRepository.findById(id);
    }

    /**
     * 
     * @param id
     * @return
     */
    public Mono<Void> remove(Long id) {
        return userRepository.deleteById(id);
    }

    /**
     * 
     * @param userResource
     * @return
     */
    public Mono<User> create(UserResource userResource) {
        User user = new User();
        user.setIdentityNumber(userResource.getIdentityNumber());
        user.setName(userResource.getName());
        user.setLastName(userResource.getLastName());
        user.setAddress(userResource.getAddress());

        log.info("[UserService][create][User created!]");
        return userRepository.save(user).map(u -> {
            User userFromDB = new User();
            userFromDB.setId(u.getId());
            userFromDB.setName(u.getName());
            userFromDB.setLastName(u.getLastName());
            return userFromDB;
        });

    }

}
