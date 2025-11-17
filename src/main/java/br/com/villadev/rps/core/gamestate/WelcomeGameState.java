package br.com.villadev.rps.core.gamestate;

import br.com.villadev.rps.parser.CLIInteractionHelper;
import br.com.villadev.rps.presentation.GameMenu;
import br.com.villadev.rps.presentation.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;

class WelcomeGameState extends GameState {

    private final RPSStateMachine machine;

    WelcomeGameState(RPSStateMachine machine) {
        this.machine = machine;
    }

    @Override
    public void printStatus() {
        System.out.println("in WelcomeState");
    }

    @Override
    public GameState handleRequest(final BufferedReader reader) throws IOException {
        while (true) {
            CLIInteractionHelper.print(GameMenu.WELCOME_OPTION);
            MenuItem menuItem = CLIInteractionHelper.readInput(GameMenu.WELCOME_OPTION, reader.readLine());
            if (menuItem == null) {
                System.out.println("Invalid option, please select from the Menu");
                return this;
            }
            switch (menuItem.number()) {
                case "1":
                    return machine.getHelpState();
                case "2":
                    return machine.getMatchState();
                case "3":
                    return machine.getExitGameState();
                default:
                    System.out.println("Invalid option, please select from the Menu");
                    return this;
            }
        }
    }
}
