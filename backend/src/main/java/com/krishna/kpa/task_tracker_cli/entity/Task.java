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

    @Positive(message = "id of the task needs to be positive")
    private Integer id;

    @Size(min = 1, max = 100, message = "name size should be between 1 and 100")
    @NotBlank(message = "name cannot be blank")
    private String name;

    @Size(min = 1, max = 255, message = "description size should be between 1 and 100")
    @NotBlank(message = "name cannot be blank")
    private String description;

    @Future(message = "alert time needs to be future")
    private LocalDateTime alertTime;

    @NotNull(message = "status value cannot be null")
    private TaskStatus status;

    @LastModifiedDate
    private LocalDateTime lastUpdatedTime;

    @CreatedDate
    private LocalDateTime createdTime;
}
