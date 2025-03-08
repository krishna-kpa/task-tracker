package com.krishna.kpa.task_tracker_cli.controller;

import com.krishna.kpa.task_tracker_cli.dto.TaskDTO;
import com.krishna.kpa.task_tracker_cli.enums.TaskStatus;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller - this allows users to perform all operations that are related to tasks.
 *
 * @author Krishna Prasad A
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Task Tracker API",
                version = "1.0",
                description = "Handles task-related operations",
                contact = @Contact(
                        name = "Krishna Prasad A",
                        email = "krishnaprasad.kp9048@gmail.com",
                        url = "https://krishna-kpa.vercel.app/"
                )
        ),
        tags = {
                @Tag(name = "Task Tracker Controller", description = "All operations related to tasks")
        }
)
public interface TaskTrackerController {

    /**
     * Fetch all tasks based on filters.
     *
     * @param id     Single task ID
     * @param ids    List of task IDs
     * @param status Task status filter
     * @return List of tasks matching filters
     */
    @Operation(
            summary = "Fetch tasks with filters",
            description = "Fetch all tasks using optional filters such as ID, multiple IDs, or status.",
            tags = {"Task Tracker Controller"},
            parameters = {
                    @Parameter(name = "id", description = "Task ID", example = "1", required = false),
                    @Parameter(name = "ids", description = "List of task IDs", example = "[1,2,3]", required = false),
                    @Parameter(name = "status", description = "Task status", required = false,
                            schema = @Schema(implementation = TaskStatus.class))
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful retrieval",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = TaskDTO.class)))),
                    @ApiResponse(responseCode = "400", description = "Invalid input"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    ResponseEntity<List<TaskDTO>> getAllTaskUsingFilter(
            Integer id,
            List<Integer> ids,
            TaskStatus status
    );

    /**
     * Delete a task by its ID.
     *
     * @param id Task ID
     * @return True if deletion was successful
     */
    @Operation(
            summary = "Delete task by ID",
            description = "Deletes a task given its ID.",
            tags = {"Task Tracker Controller"},
            parameters = @Parameter(name = "id", description = "Task ID", required = true, example = "1"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task deleted successfully",
                            content = @Content(schema = @Schema(implementation = Boolean.class))),
                    @ApiResponse(responseCode = "404", description = "Task not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    ResponseEntity<Boolean> deleteTaskById(Integer id);

    /**
     * Update a task by its ID.
     *
     * @param id        Task ID
     * @param inputTask Task update payload
     * @return True if the update was successful
     */
    @Operation(
            summary = "Update task by ID",
            description = "Updates a task's details using the given ID and TaskDTO payload.",
            tags = {"Task Tracker Controller"},
            parameters = @Parameter(name = "id", description = "Task ID", required = true, example = "1"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Task update details",
                    required = true,
                    content = @Content(schema = @Schema(implementation = TaskDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task updated successfully",
                            content = @Content(schema = @Schema(implementation = Boolean.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input"),
                    @ApiResponse(responseCode = "404", description = "Task not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    ResponseEntity<Boolean> updateTaskById(Integer id, TaskDTO inputTask);

    /**
     * Create a new task.
     *
     * @param taskDTO Task data
     * @return True if creation was successful
     */
    @Operation(
            summary = "Create a new task",
            description = "Creates a new task with the given details.",
            tags = {"Task Tracker Controller"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Task creation details",
                    required = true,
                    content = @Content(schema = @Schema(implementation = TaskDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Task created successfully",
                            content = @Content(schema = @Schema(implementation = Boolean.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    ResponseEntity<Boolean> createTask(TaskDTO taskDTO);
}
