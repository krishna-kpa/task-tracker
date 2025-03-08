package com.krishna.kpa.data;

import com.krishna.kpa.dto.TaskDTO;
import com.krishna.kpa.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DummyDevData {

    public static List<TaskDTO> TASKS = generateDummyTasks();

    public static List<TaskDTO> generateDummyTasks() {
        List<TaskDTO> tasks = new ArrayList<>();

        tasks.add(createTask(1, "Math Study", "Complete algebra and calculus exercises.", 2, "TODO"));
        tasks.add(createTask(2, "Go Swimming", "Swim for 30 minutes in the evening.", 5, "DONE"));
        tasks.add(createTask(3, "Do Coding", "Work on Spring Boot microservice project.", 1, "IN_PROGRESS"));
        tasks.add(createTask(4, "Team Meeting", "Attend stand-up meeting at 10 AM.", 1, "TODO"));
        tasks.add(createTask(5, "Grocery Shopping", "Buy vegetables, milk, and fruits.", 3, "DONE"));
        tasks.add(createTask(6, "Read a Book", "Read 20 pages of 'Clean Code'.", 2, "TODO"));
        tasks.add(createTask(7, "Workout", "Do 1-hour weight training at the gym.", 1, "IN_PROGRESS"));
        tasks.add(createTask(8, "Write Blog", "Write an article on Java Design Patterns.", 4, "TODO"));
        tasks.add(createTask(9, "Client Call", "Discuss project updates with the client.", 1, "DONE"));
        tasks.add(createTask(10, "Watch Tech Talk", "Attend online session on Kubernetes.", 2, "TODO"));
        tasks.add(createTask(11, "Pay Bills", "Electricity and internet bill payments.", 1, "DONE"));
        tasks.add(createTask(12, "Fix Bugs", "Resolve 5 reported issues in the app.", 3, "IN_PROGRESS"));
        tasks.add(createTask(13, "Practice DSA", "Solve 5 LeetCode problems.", 2, "TODO"));
        tasks.add(createTask(14, "Go for a Walk", "Take a 20-minute walk after dinner.", 1, "DONE"));
        tasks.add(createTask(15, "Check Emails", "Respond to important work emails.", 1, "TODO"));
        tasks.add(createTask(16, "Prepare Presentation", "Prepare slides for the team meeting.", 3, "IN_PROGRESS"));
        tasks.add(createTask(17, "Review PR", "Review and merge pending pull requests.", 1, "TODO"));
        tasks.add(createTask(18, "Practice Guitar", "Practice playing 'Wonderwall'.", 2, "DONE"));
        tasks.add(createTask(19, "Plan Weekend", "Decide on weekend trip and bookings.", 4, "TODO"));
        tasks.add(createTask(20, "Backup Data", "Take a backup of important project files.", 2, "IN_PROGRESS"));

        return tasks;
    }

    // Helper method to create a task with proper details
    public static TaskDTO createTask(int id, String name, String description, int alertInDays, String status) {
        TaskDTO task = new TaskDTO();
        task.setId(id);
        task.setName(name);
        task.setDescription(description);
        task.setAlertTime(LocalDateTime.now().plusDays(alertInDays)); // Future alert time
        task.setStatus(TaskStatus.valueOf(status));
        task.setCreatedTime(LocalDateTime.now().minusDays(1)); // Created yesterday
        task.setLastUpdatedTime(LocalDateTime.now()); // Updated just now
        return task;
    }
}
