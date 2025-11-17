package br.com.villadev.rps.parser;

import br.com.villadev.rps.presentation.GameMenu;
import br.com.villadev.rps.presentation.MenuItem;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class CLIInteractionHelperTest {

    @Test
    void promptUntilValid_skips_invalid_and_returns_valid() throws IOException {
        String input = "foo\n2\n"; // invalid then valid for WELCOME: 2 -> Start game
        try (BufferedReader reader = new BufferedReader(new StringReader(input))) {
            MenuItem item = CLIInteractionHelper.promptUntilValid(GameMenu.WELCOME_OPTION, reader);
            assertNotNull(item);
            assertEquals("2", item.number());
            assertEquals("Start game", item.text());
        }
    }

    @Test
    void promptUntilValid_returns_null_on_eof() throws IOException {
        String input = ""; // EOF immediately
        try (BufferedReader reader = new BufferedReader(new StringReader(input))) {
            MenuItem item = CLIInteractionHelper.promptUntilValid(GameMenu.WELCOME_OPTION, reader);
            assertNull(item);
        }
    }
}
