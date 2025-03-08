package com.krishna.kpa.dto;

import com.krishna.kpa.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DTO - for representing Task
 *
 * @author Krishna Prasad A
 */
@Getter
@Setter
public class TaskDTO {

    private Integer id;

    private String name;

    private String description;

    private LocalDateTime alertTime;

    private TaskStatus status;

    private LocalDateTime lastUpdatedTime;

    private LocalDateTime createdTime;
}
