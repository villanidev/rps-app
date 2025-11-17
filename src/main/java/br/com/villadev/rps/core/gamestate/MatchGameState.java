package br.com.villadev.rps.core.gamestate;

import br.com.villadev.rps.core.entities.*;
import br.com.villadev.rps.parser.CLIInteractionHelper;
import br.com.villadev.rps.presentation.GameMenu;
import br.com.villadev.rps.presentation.MenuItem;
import br.com.villadev.rps.core.engine.GameEngine;
import br.com.villadev.rps.core.engine.Outcome;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class MatchGameState extends GameState {

    private final RPSStateMachine machine;
    private final GameContext context;

    private final Map<String, PlayerRole> availableRoles = new HashMap<>();
    private int rounds = 0;
    private final int defaultRounds;
    private final GameEngine engine = new GameEngine();

    MatchGameState(RPSStateMachine machine, GameContext context) {
        this.machine = machine;
        this.context = context;
        this.defaultRounds = context.getDefaultRounds();
        availableRoles.put("0", new Rock());
        availableRoles.put("1", new Paper());
        availableRoles.put("2", new Scissors());
    }

    void reset() {
        this.rounds = 0;
    }

    @Override
    public void printStatus() {
        System.out.println("in MatchState");
    }

    @Override
    public GameState handleRequest(final BufferedReader reader) throws IOException {
        if (engine.isFinished(rounds, defaultRounds)) return machine.getReplayState();

        int randomNumber;
        Player computer = new Player("computer");
        Player user = new Player("user");

        CLIInteractionHelper.print(GameMenu.PLAYER_ROLE_OPTION);
        MenuItem menuItem = CLIInteractionHelper.readInput(GameMenu.PLAYER_ROLE_OPTION, reader.readLine());

        if (menuItem == null) {
            System.out.println("Invalid option, please select from the Menu");
            return this;
        }

        switch (menuItem.number()) {
            case "1":
                randomNumber = context.getRandom().nextInt(availableRoles.size());
                computer.setRole(availableRoles.get(String.valueOf(randomNumber)));
                user.setRole(new Rock());
                printResult(user, computer);
                rounds++;
                return this;
            case "2":
                randomNumber = context.getRandom().nextInt(availableRoles.size());
                computer.setRole(availableRoles.get(String.valueOf(randomNumber)));
                user.setRole(new Paper());
                printResult(user, computer);
                rounds++;
                return this;
            case "3":
                randomNumber = context.getRandom().nextInt(availableRoles.size());
                computer.setRole(availableRoles.get(String.valueOf(randomNumber)));
                user.setRole(new Scissors());
                printResult(user, computer);
                rounds++;
                return this;
            default:
                System.out.println("Invalid option, please select from the Menu");
                return this;
        }
    }

    private void printResult(final Player user, final Player computer) {
        System.out.println("you have chosen: " + user.getRole().alias());
        System.out.println("computer has chosen: " + computer.getRole().alias());
        Outcome outcome = engine.decide(user.getRole().alias(), computer.getRole().alias());
        System.out.println("round winner is: " + engine.toHumanMessage(outcome));
    }
}
