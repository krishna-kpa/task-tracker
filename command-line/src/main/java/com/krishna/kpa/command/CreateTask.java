package com.krishna.kpa.command;

import com.krishna.kpa.dto.TaskDTO;
import com.krishna.kpa.enums.TaskStatus;
import com.krishna.kpa.service.TaskTrackerCLIService;
import picocli.CommandLine.Option;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.krishna.kpa.styles.ConsoleStyles.*;

public class CreateTask implements Runnable {

    private static final TaskTrackerCLIService taskTrackerCLIService = new TaskTrackerCLIService();

    @Option(names = {"-n", "--name"}, required = true, description = "Name of the task")
    private String name;

    @Option(names = {"-s", "--status"}, description = "Task status (TODO, IN_PROGRESS, COMPLETED)")
    private String status = "TODO";  // Default status

    @Option(names = {"-d", "--description"}, description = "Optional description of the task")
    private String description;

    @Option(names = {"-a", "--alert"}, description = "Alert time in format (dd-MM-yyyy HH:mm) or (dd-MM-yyyy-HH:mm)")
    private String alertTime;

    @Override
    public void run() {
        LocalDateTime parsedAlertTime = null;

        if (alertTime != null) {
            try {
                // Try parsing with space format
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                parsedAlertTime = LocalDateTime.parse(alertTime, formatter1);
            } catch (DateTimeParseException e1) {
                try {
                    // Try parsing with dash format
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm");
                    parsedAlertTime = LocalDateTime.parse(alertTime, formatter2);
                } catch (DateTimeParseException e2) {
                    System.out.println("⚠️ Invalid alert time format! Use 'dd-MM-yyyy HH:mm' or 'dd-MM-yyyy-HH:mm'");
                    return;
                }
            }
        }
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setName(name);
        taskDTO.setDescription(description);
        taskDTO.setAlertTime(parsedAlertTime);
        taskDTO.setStatus(TaskStatus.valueOf(status));

        // Save task
        boolean isCreated = taskTrackerCLIService.createTask(taskDTO);

        // Display Result
        if (isCreated) {
            System.out.println(GREEN + "✅ Task '" + name + "' created successfully!" + RESET);
            System.out.println("Name: " + name);
            System.out.println("Status: " + status);
            System.out.println("Description: " + description);
            if (parsedAlertTime != null) {
                System.out.println("Alert Time: " + parsedAlertTime);
            }
        } else {
            System.out.println(RED + "❌ Failed to create task. Please check the inputs and try again!" + RESET);
        }
    }
}
