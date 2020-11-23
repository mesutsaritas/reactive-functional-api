package com.mesutsaritas.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.mesutsaritas.model.User;

/**
 * @author msaritas
 *
 */

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Long> {
}
