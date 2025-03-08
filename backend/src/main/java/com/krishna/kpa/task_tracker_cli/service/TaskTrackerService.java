package com.krishna.kpa.task_tracker_cli.service;

import com.krishna.kpa.task_tracker_cli.dto.TaskDTO;
import com.krishna.kpa.task_tracker_cli.enums.TaskStatus;

import java.util.List;

/**
 * Service layer for handling task-related business logic.
 * This class is responsible for processing task data before sending it to the DAO layer.
 *
 * @author Krishna Prasad A
 */
public interface TaskTrackerService {

    /**
     * Fetch all tasks based on filters.
     *
     * @param id     Single task ID (optional)
     * @param ids    List of task IDs (optional)
     * @param status Task status filter (optional)
     * @return List of tasks matching filters
     */
    List<TaskDTO> getAllTasks(Integer id, List<Integer> ids, TaskStatus status);

    /**
     * Delete a task by its ID.
     *
     * @param id Task ID
     * @return True if deletion was successful
     */
    boolean deleteTaskById(Integer id);

    /**
     * Update a task by its ID.
     *
     * @param id        Task ID
     * @param inputTask Task update data
     * @return True if update was successful
     */
    boolean updateTaskById(Integer id, TaskDTO inputTask);

    /**
     * Create a new task.
     *
     * @param taskDTO Task data
     * @return True if task was successfully created
     */
    boolean createTask(TaskDTO taskDTO);
}
