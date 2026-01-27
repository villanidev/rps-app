package br.com.villadev.rps.core.gamestate;

import br.com.villadev.rps.parser.CLIInteractionHelper;
import br.com.villadev.rps.presentation.GameMenu;
import br.com.villadev.rps.presentation.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;

class ReplayGameState extends GameState {

    private final RPSStateMachine machine;

    ReplayGameState(RPSStateMachine machine) {
        this.machine = machine;
    }
    @Override
    public void printStatus() {
        System.out.println("in ReplayState");
    }

    @Override
    public GameState handleRequest(final BufferedReader reader) throws IOException {
        MenuItem menuItem = CLIInteractionHelper.promptUntilValid(GameMenu.REPLAY_OPTION, reader);
        if (menuItem == null) return machine.getExitGameState();
        return switch (menuItem.number()) {
            case "1" -> machine.getMatchState();
            case "2" -> machine.getExitGameState();
            default -> this;
        };
    }
}
