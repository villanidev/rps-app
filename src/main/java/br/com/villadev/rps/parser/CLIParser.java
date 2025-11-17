package br.com.villadev.rps.parser;

import br.com.villadev.rps.presentation.GameMenu;
import br.com.villadev.rps.presentation.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.function.Predicate;

public class CLIParser {

    private static final Logger log = LoggerFactory.getLogger(CLIParser.class);

    public static MenuItem parse(GameMenu gameMenu, String text) {
        log.debug("Received menu: {}, and answer: {}", gameMenu, text);
        Optional<MenuItem> optionalMenuItem = gameMenu.getOptions()
                .stream()
                .filter(filterByNumberOrDescription(text))
                .findFirst();

        return optionalMenuItem.orElse(null);
    }

    private static Predicate<MenuItem> filterByNumberOrDescription(final String text) {
        return menu -> menu.number().equalsIgnoreCase(text)
                || menu.text().trim().equalsIgnoreCase(text);
    }
}
