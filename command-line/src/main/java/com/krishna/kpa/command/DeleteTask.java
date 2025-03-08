package com.krishna.kpa.command;

import com.krishna.kpa.service.TaskTrackerCLIService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/**
 * Command for deleting a task using its ID
 *
 * @author Krishna Prasad A
 */
@Command(name = "delete", description = "Deletes an existing task")
public class DeleteTask implements Runnable {

    @Option(names = {"-i", "--id"}, required = true, description = "ID of the task to delete")
    private Integer taskId;

    private final TaskTrackerCLIService taskService = new TaskTrackerCLIService();

    @Override
    public void run() {
        if (taskId == null) {
            System.out.println("⚠️ Task ID is required!");
            return;
        }

        try {
            boolean success = taskService.deleteTask(taskId);
            if (success) {
                System.out.println("✅ Task Deleted Successfully!");
            } else {
                System.out.println("❌ Task Deletion Failed! Task ID may not exist.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error deleting task: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
