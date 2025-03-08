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
 * Entity representing the user.
 *
 * @author Krishna Prasad A
 */
@Getter
@Setter
public class User {

    @Positive(message = "User ID must be a positive number.")
    private Integer id;

    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters.")
    @NotBlank(message = "Name cannot be empty.")
    private String name;

    @NotBlank(message = "Password cannot be empty.")
    private String password;

    @NotBlank(message = "Phone number cannot be empty.")
    @Pattern(regexp = "^(?:\\+91|91|0)?[789]\\d{9}$", message = "Invalid phone number format. It must start with +91, 91, or 0 and contain 10 digits.")
    private String phoneNumber;

    @LastModifiedDate
    private LocalDateTime lastUpdatedTime;

    @CreatedDate
    private LocalDateTime createdTime;
}
