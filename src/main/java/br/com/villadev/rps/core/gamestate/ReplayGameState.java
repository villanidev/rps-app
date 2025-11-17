package br.com.villadev.rps.core.gamestate;

import br.com.villadev.rps.parser.CLIInteractionHelper;
import br.com.villadev.rps.presentation.GameMenu;
import br.com.villadev.rps.presentation.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;

class ReplayGameState extends GameState {
    @Override
    void printStatus() {
        System.out.println("in ReplayState");
    }

    @Override
    void handleRequest(final BufferedReader reader) throws IOException {
        while (true) {
            CLIInteractionHelper.print(GameMenu.REPLAY_OPTION);
            MenuItem menuItem = CLIInteractionHelper.readInput(GameMenu.REPLAY_OPTION, reader.readLine());
            if (menuItem == null) {
                System.out.println("Invalid option, please select from the Menu");
                break;
            }

            switch (menuItem.number()) {
                case "1":
                    current = matchState;
                    return;
                case "2":
                    current = exitGameState;
                    return;
                default:
                    System.out.println("Invalid option, please select from the Menu");
            }
        }
    }
}
