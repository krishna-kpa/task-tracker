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
        System.out.println(BOLD + CYAN + "=".repeat(170) + RESET);
        System.out.printf(BOLD + CYAN + "| %-114s " + CYAN + "|\n" + RESET, YELLOW + centerText("TASK TRACKER CLI - v1.0", 167) + RESET);
        System.out.println(BOLD + CYAN + "=".repeat(170) + RESET);
        System.out.println(GREEN + "🚀 Stay organized, track tasks efficiently!\n" + RESET);
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
