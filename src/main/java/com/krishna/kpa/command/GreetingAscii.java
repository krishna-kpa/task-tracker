package com.krishna.kpa.command;

import picocli.CommandLine.Command;

/**
 * Displays a colorful and readable ASCII banner for Task Tracker.
 */
@Command(name = "home", version = "home 1.0")
public class GreetingAscii implements Runnable {

    // ANSI color codes
    private static final String RESET = "\033[0m";
    private static final String CYAN = "\033[36m";   // Cyan
    private static final String YELLOW = "\033[33m"; // Yellow
    private static final String GREEN = "\033[32m";  // Green
    private static final String BLUE = "\033[34m";   // Blue
    private static final String BOLD = "\033[1m";    // Bold

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
