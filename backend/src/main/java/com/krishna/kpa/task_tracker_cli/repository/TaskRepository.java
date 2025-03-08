package com.krishna.kpa.task_tracker_cli.repository;

import com.krishna.kpa.task_tracker_cli.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for all task related queries
 *
 * @author Krishna Prasad A
 */
@Repository
public interface TaskRepository extends MongoRepository<Task, Integer> {
}
