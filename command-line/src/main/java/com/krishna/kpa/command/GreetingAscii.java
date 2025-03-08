package com.krishna.kpa.command;

import picocli.CommandLine.Command;

import static com.krishna.kpa.styles.ConsoleStyles.*;

/**
 * Displays a colorful and readable ASCII banner for Task Tracker.
 */
@Command(name = "home", version = "home 1.0", hidden = true)
public class GreetingAscii implements Runnable {

    /**
     * Runs the banner display.
     */
    @Override
    public void run() {
        System.out.println(BOLD + CYAN + "===============================" + RESET);
        System.out.println(BOLD + YELLOW + "   TASK TRACKER CLI - v1.0    " + RESET);
        System.out.println(BOLD + CYAN + "===============================\n" + RESET);
        System.out.println(GREEN + "🚀 Stay organized, track tasks efficiently!\n" + RESET);
    }
}
