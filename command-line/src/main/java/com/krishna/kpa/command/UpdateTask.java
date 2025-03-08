package com.krishna.kpa.command;

import com.krishna.kpa.dto.TaskDTO;
import com.krishna.kpa.enums.TaskStatus;
import com.krishna.kpa.service.TaskTrackerCLIService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Command(name = "update", description = "Updates an existing task")
public class UpdateTask implements Runnable {

    @Option(names = {"-i", "--id"}, required = true, description = "ID of the task to update")
    private Integer taskId;  // Use wrapper to handle missing input

    @Option(names = {"-n", "--name"}, description = "New name of the task")
    private String name;

    @Option(names = {"-s", "--status"}, description = "New task status (TODO, IN_PROGRESS, COMPLETED)")
    private String status;

    @Option(names = {"-d", "--description"}, description = "New description of the task")
    private String description;

    @Option(names = {"-a", "--alert"}, description = "New alert time (format: dd-MM-yyyy HH:mm or dd-MM-yyyy-HH:mm)")
    private String alertTime;

    private final TaskTrackerCLIService taskService = new TaskTrackerCLIService(); // Service layer

    @Override
    public void run() {
        if (taskId == null) {
            System.out.println("⚠️ Task ID is required!");
            return;
        }

        LocalDateTime parsedAlertTime = null;
        if (alertTime != null && !alertTime.isEmpty()) {
            parsedAlertTime = parseAlertTime(alertTime);
            if (parsedAlertTime == null) {
                return; // Invalid format, error already printed
            }
        }

        TaskStatus taskStatus = null;
        if (status != null && !status.isEmpty()) {
            try {
                taskStatus = TaskStatus.valueOf(status.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("⚠️ Invalid status! Allowed values: TODO, IN_PROGRESS, COMPLETED");
                return;
            }
        }

        // ✅ Create DTO with updated values
        TaskDTO updatedTask = new TaskDTO();
        updatedTask.setName(name != null && !name.isEmpty() ? name : null);
        updatedTask.setDescription(description != null && !description.isEmpty() ? description : null);
        updatedTask.setAlertTime(parsedAlertTime);
        updatedTask.setStatus(taskStatus);

        // ✅ Call service to update task
        try {
            boolean success = taskService.updateTask(taskId, updatedTask);
            if (success) {
                System.out.println("✅ Task Updated Successfully!");
            } else {
                System.out.println("❌ Task Update Failed!");
            }
        } catch (Exception e) {
            System.out.println("❌ Error updating task: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private LocalDateTime parseAlertTime(String alertTime) {
        try {
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            return LocalDateTime.parse(alertTime, formatter1);
        } catch (DateTimeParseException e1) {
            try {
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm");
                return LocalDateTime.parse(alertTime, formatter2);
            } catch (DateTimeParseException e2) {
                System.out.println("⚠️ Invalid alert time format! Use 'dd-MM-yyyy HH:mm' or 'dd-MM-yyyy-HH:mm'");
                return null;
            }
        }
    }
}
