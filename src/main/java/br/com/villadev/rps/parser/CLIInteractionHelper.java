package br.com.villadev.rps.parser;

import br.com.villadev.rps.presentation.GameMenu;
import br.com.villadev.rps.presentation.MenuItem;

import java.text.MessageFormat;
import java.io.BufferedReader;
import java.io.IOException;

public class CLIInteractionHelper {

    public static void print(GameMenu menuOption) {
        System.out.println(menuOption.getDescription());
        menuOption.getOptions().forEach(menuItem -> {
            System.out.println(MessageFormat.format("{0}-{1}", menuItem.number(), menuItem.text()));
        });
    }

    /**
     * Prompts the user for an integer value with bounds and a default. If the user inputs an empty line,
     * the defaultValue is returned. Keeps prompting until a valid integer within [min, max] is provided.
     * Returns null if EOF is reached (reader.readLine() == null).
     */
    public static Integer promptIntWithDefault(String prompt, BufferedReader reader, int defaultValue, int min, int max) throws IOException {
        while (true) {
            System.out.println(prompt + " [default: " + defaultValue + "]");
            String line = reader.readLine();
            if (line == null) {
                return null; // EOF
            }
            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                return defaultValue;
            }
            try {
                int value = Integer.parseInt(trimmed);
                if (value < min || value > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    public static MenuItem readInput(GameMenu menuOption, String text) {
        return CLIParser.parse(menuOption, text);
    }

    /**
     * Prints a menu and keeps asking the user until a valid option is entered.
     * Returns the selected MenuItem. Returns null if the reader is closed (EOF).
     */
    public static MenuItem promptUntilValid(GameMenu menuOption, BufferedReader reader) throws IOException {
        while (true) {
            print(menuOption);
            String line = reader.readLine();
            if (line == null) {
                return null; // EOF -> let caller decide how to terminate
            }
            MenuItem item = readInput(menuOption, line);
            if (item != null) {
                return item;
            }
            System.out.println("Invalid option, please select from the Menu");
        }
    }
}
