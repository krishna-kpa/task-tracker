package com.krishna.kpa;

import com.krishna.kpa.command.GreetingAscii;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.Scanner;

/**
 * Root command that handles CLI execution.
 */
@Command(name = "task-tracker", description = "A simple Task Tracker CLI", mixinStandardHelpOptions = true, version = "1.0")
public class App implements Runnable {

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args); // Start CLI
    }

    @Override
    public void run() {
        CommandLine cmd = new CommandLine(this)
                .addSubcommand("greet", new GreetingAscii());

        cmd.execute("greet");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Exiting Task Tracker... Goodbye! 👋");
                break;
            }

            int exitCode = cmd.execute(input.split("\\s+"));
            if (exitCode != 0) {
                System.out.println("⚠️ Invalid command! Type --help for usage.");
            }
        }
        scanner.close();
    }
}
