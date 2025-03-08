package com.krishna.kpa.task_tracker_cli.entity;

import com.krishna.kpa.task_tracker_cli.enums.TaskStatus;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * Entity representing the task.
 *
 * @author Krishna Prasad A
 */
@Getter
@Setter
public class Task {

    @Positive(message = "Task ID must be a positive number.")
    private Integer id;

    @Size(min = 1, max = 100, message = "Task name must be between 1 and 100 characters.")
    @NotBlank(message = "Task name cannot be empty.")
    private String name;

    @Size(min = 1, max = 255, message = "Task description must be between 1 and 255 characters.")
    @NotBlank(message = "Task description cannot be empty.")
    private String description;

    @Future(message = "Alert time must be in the future.")
    private LocalDateTime alertTime;

    @NotNull(message = "Task status cannot be null.")
    private TaskStatus status;

    @LastModifiedDate
    private LocalDateTime lastUpdatedTime;

    @CreatedDate
    private LocalDateTime createdTime;
}
