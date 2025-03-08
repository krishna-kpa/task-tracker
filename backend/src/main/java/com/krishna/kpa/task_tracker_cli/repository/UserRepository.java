package com.krishna.kpa.task_tracker_cli.repository;

import com.krishna.kpa.task_tracker_cli.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for all user related queries
 *
 * @author Krishna Prasad A
 */
@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
}
