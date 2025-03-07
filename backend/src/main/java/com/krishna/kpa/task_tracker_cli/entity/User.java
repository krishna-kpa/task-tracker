package com.krishna.kpa.task_tracker_cli.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * Entity representing the user
 *
 * @author Krishna Prasad A
 */
@Getter
@Setter
public class User {

    @Positive(message = "id of the task needs to be positive")
    private Integer id;

    @Size(min = 1, max = 100, message = "name size should be between 1 and 100")
    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotBlank(message = "password value cannot be blank")
    private String password;

    @NotBlank(message = "phone number value cannot be blank")
    @Pattern(regexp = "^(?:\\+91|91|0)?[789]\\d{9}$", message = "phone number pattern not matching")
    private String phoneNumber;

    @LastModifiedDate
    private LocalDateTime lastUpdatedTime;

    @CreatedDate
    private LocalDateTime createdTime;
}
