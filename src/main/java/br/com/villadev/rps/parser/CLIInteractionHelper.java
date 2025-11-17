package br.com.villadev.rps.parser;

import br.com.villadev.rps.presentation.GameMenu;
import br.com.villadev.rps.presentation.MenuItem;

import java.text.MessageFormat;

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
}
