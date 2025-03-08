package com.krishna.kpa.command;

import com.krishna.kpa.dto.TaskDTO;
import com.krishna.kpa.enums.TaskStatus;
import com.krishna.kpa.service.TaskTrackerCLIService;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import static com.krishna.kpa.styles.ConsoleStyles.*;

@Command(
        name = "list",
        version = "1.0",
        description = "for listing all the tasks available in the system"
)
public class ListTask implements Runnable {

    private final TaskTrackerCLIService taskTrackerCLIService = new TaskTrackerCLIService();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");

    @CommandLine.Option(names = {"-s", "--status"}, description = "status of the tasks that you want to show")
    TaskStatus taskStatus;

    @CommandLine.Option(names = {"-i", "--id"}, description = "id of the task that you want to show")
    Integer id;

    @CommandLine.Option(
            names = {"-in", "--ids"},
            description = "set of ids of tasks that you want to show",
            arity = "1..*",
            split = ","
    )
    Set<Integer> ids;

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        // Validation: Ensure `id` is used alone
        if (id != null && (ids != null || taskStatus != null)) {
            System.out.println(RED + "⚠️ Invalid command! The '--id' option must be used alone. " +
                    "Use '--ids' instead if filtering multiple tasks." + RESET);
            return;
        }

        // Fetch tasks based on the valid combination of filters
        List<TaskDTO> tasks = taskTrackerCLIService.getAllTask(id, taskStatus, ids);

        // Print task list
        printTaskList(tasks);
    }

    /**
     * Prints the formatted task list.
     */
    private void printTaskList(List<TaskDTO> tasks) {
        // Constants for formatting
        final String BORDER = RED + "+-----+---------------------------+----------------------------------------------------+----------------------+-------------+----------------------+----------------------+" + RESET;
        final String HEADER_FORMAT = RED + "| " + YELLOW_BRIGHT + "%-3s" + RED + " | "
                + YELLOW_BRIGHT + "%-25s" + RED + " | "
                + YELLOW_BRIGHT + "%-50s" + RED + " | "
                + YELLOW_BRIGHT + "%-20s" + RED + " | "
                + YELLOW_BRIGHT + "%-11s" + RED + " | "
                + YELLOW_BRIGHT + "%-20s" + RED + " | "
                + YELLOW_BRIGHT + "%-20s " + RED + "|\n" + RESET;

        final String ROW_FORMAT = RED + "| " + YELLOW_BRIGHT + "%-3s" + RED + " | "
                + YELLOW_BRIGHT + "%-25s" + RED + " | "
                + YELLOW_BRIGHT + "%-50s" + RED + " | "
                + YELLOW_BRIGHT + "%-20s" + RED + " | "
                + YELLOW_BRIGHT + "%-11s" + RED + " | "
                + YELLOW_BRIGHT + "%-20s" + RED + " | "
                + YELLOW_BRIGHT + "%-20s " + RED + "|\n" + RESET;

        // Print header
        System.out.println(BORDER);
        System.out.printf(RED + "| %-114s " + RED + "|\n" + RESET, BLUE + centerText("TASKS LIST", 167) + RESET);
        System.out.println(BORDER);
        System.out.printf(HEADER_FORMAT, "ID", "Name", "Description", "Alert Time", "Status", "Created Time", "Last Updated");
        System.out.println(BORDER);

        // Print task data
        for (TaskDTO task : tasks) {
            System.out.printf(ROW_FORMAT,
                    task.getId(),
                    centerText(task.getName(), 25),
                    centerText(task.getDescription() != null ? task.getDescription() : "N/A", 50),
                    centerText(formatDateTime(task.getAlertTime()), 20),
                    centerText(task.getStatus().toString(), 11),
                    centerText(formatDateTime(task.getCreatedTime()), 20),
                    centerText(formatDateTime(task.getLastUpdatedTime()), 20)
            );
        }

        // Print footer
        System.out.println(BORDER);
    }

    /**
     * Formats LocalDateTime to a readable string.
     */
    private String formatDateTime(LocalDateTime dateTime) {
        return (dateTime != null) ? dateTime.format(FORMATTER) : "N/A";
    }

    /**
     * Centers text in a given width.
     */
    private String centerText(String text, int width) {
        if (text.length() >= width) return text.substring(0, width); // Truncate if too long
        int padding = (width - text.length()) / 2;
        int extraPadding = (width - text.length()) % 2; // Handle odd-length cases
        return " ".repeat(padding) + text + " ".repeat(padding + extraPadding);
    }
}
