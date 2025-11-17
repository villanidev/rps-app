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
