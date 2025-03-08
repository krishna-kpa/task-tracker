package com.krishna.kpa.task_tracker_cli.controller.impl;

import com.fasterxml.jackson.annotation.JsonView;
import com.krishna.kpa.task_tracker_cli.controller.TaskTrackerController;
import com.krishna.kpa.task_tracker_cli.dto.TaskDTO;
import com.krishna.kpa.task_tracker_cli.enums.TaskStatus;
import com.krishna.kpa.task_tracker_cli.service.TaskTrackerService;
import com.krishna.kpa.task_tracker_cli.validation.groups.ApiInputCreate;
import com.krishna.kpa.task_tracker_cli.validation.groups.ApiInputUpdate;
import com.krishna.kpa.task_tracker_cli.validation.groups.ApiOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller - this allows users to perform all operations that are related to task.
 *
 * @author Krishna Prasad A
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskControllerImpl implements TaskTrackerController {

    private final TaskTrackerService taskTrackerService;

    /**
     * Fetch all tasks based on filters.
     *
     * @param id     Single task ID
     * @param ids    List of task IDs
     * @param status Task status filter
     * @return List of tasks matching filters
     */
    @Override
    @GetMapping
    @JsonView(ApiOutput.class)
    public ResponseEntity<List<TaskDTO>> getAllTaskUsingFilter(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) List<Integer> ids,
            @RequestParam(required = false) TaskStatus status) {
        return null;
    }

    /**
     * Delete a task by its ID.
     *
     * @param id Task ID
     * @return True if deletion was successful
     */
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTaskById(@PathVariable Integer id) {
        return null;
    }

    /**
     * Update a task by its ID.
     *
     * @param id        Task ID
     * @param inputTask Task update payload
     * @return True if the update was successful
     */
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateTaskById(
            @PathVariable Integer id,
            @RequestBody
            @JsonView(ApiInputUpdate.class)
            @Validated(ApiInputUpdate.class) TaskDTO inputTask) {
        return null;
    }

    /**
     * Create a new task.
     *
     * @param taskDTO Task data
     * @return True if creation was successful
     */
    @Override
    @PostMapping
    public ResponseEntity<Boolean> createTask(
            @JsonView(ApiInputCreate.class)
            @RequestBody
            @Validated(ApiInputCreate.class)
            TaskDTO taskDTO) {

        return null;
    }
}
