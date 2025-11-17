package br.com.villadev.rps.core.gamestate;

import br.com.villadev.rps.parser.CLIInteractionHelper;
import br.com.villadev.rps.presentation.GameMenu;
import br.com.villadev.rps.presentation.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;

class WelcomeGameState extends GameState {

    @Override
    void printStatus() {
        System.out.println("in WelcomeState");
    }

    @Override
    void handleRequest(final BufferedReader reader) throws IOException {
        while (true) {
            CLIInteractionHelper.print(GameMenu.WELCOME_OPTION);
            MenuItem menuItem = CLIInteractionHelper.readInput(GameMenu.WELCOME_OPTION, reader.readLine());
            if (menuItem == null) {
                System.out.println("Invalid option, please select from the Menu");
                break;
            }
            switch (menuItem.number()) {
                case "1":
                    current = helpState;
                    return;
                case "2":
                    current = matchState;
                    return;
                case "3":
                    current = exitGameState;
                    return;
            }
        }
    }
}
