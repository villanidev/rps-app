package br.com.villadev.rps.core.gamestate;

import br.com.villadev.rps.core.entities.*;
import br.com.villadev.rps.parser.CLIInteractionHelper;
import br.com.villadev.rps.presentation.GameMenu;
import br.com.villadev.rps.presentation.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class MatchGameState extends GameState {

    Map<String, PlayerRole> availableRoles = new HashMap<>();

    public MatchGameState() {
        availableRoles.put("0", new Rock());
        availableRoles.put("1", new Paper());
        availableRoles.put("2", new Scissors());
    }
    @Override
    void printStatus() {
        System.out.println("in MatchState");
    }

    @Override
    void handleRequest(final BufferedReader reader) throws IOException {
        int defaultRounds = 3;
        int rounds = 0;
        int randomNumber;
        Player computer = new Player("computer");
        Player user = new Player("user");

        while (true) {

            if (rounds == defaultRounds) {
                current = replayState;
                return;
            }

            CLIInteractionHelper.print(GameMenu.PLAYER_ROLE_OPTION);
            MenuItem menuItem = CLIInteractionHelper.readInput(GameMenu.PLAYER_ROLE_OPTION, reader.readLine());

            if (menuItem == null) {
                System.out.println("Invalid option, please select from the Menu");
                break;
            }

            switch (menuItem.number()) {
                case "1":
                    randomNumber = new Random().nextInt(availableRoles.size());
                    computer.setRole(availableRoles.get(String.valueOf(randomNumber)));
                    user.setRole(new Rock());
                    printResult(user, computer);
                    current = this;
                    rounds++;
                    break;
                case "2":
                    randomNumber = new Random().nextInt(availableRoles.size());
                    computer.setRole(availableRoles.get(String.valueOf(randomNumber)));
                    user.setRole(new Paper());
                    printResult(user, computer);
                    current = this;
                    rounds++;
                    break;
                case "3":
                    randomNumber = new Random().nextInt(availableRoles.size());
                    computer.setRole(availableRoles.get(String.valueOf(randomNumber)));
                    user.setRole(new Scissors());
                    printResult(user, computer);
                    current = this;
                    rounds++;
                    break;
            }
        }
    }

    private void printResult(final Player user, final Player computer) {
        System.out.println("you have chosen: " + user.getRole().alias());
        System.out.println("computer has chosen: " + computer.getRole().alias());
        System.out.println("round winner is: " +
                calculateWinner(user.getRole().alias(), computer.getRole().alias()));
    }

    private String calculateWinner(String userRole, String computerRole) {
        if (userRole.equals(computerRole)) {
            return "Nobody, it's a tie!";
        } else if (isPlayerWin(userRole, computerRole)) {
            return "You won!";
        } else {
            return "Computer won!";
        }
    }

    private boolean isPlayerWin(String userRole, String computerRole) {
        return userRole.equals("rock") && computerRole.equals("scissors")
                || (userRole.equals("scissors") && computerRole.equals("paper"))
                || (userRole.equals("paper") && computerRole.equals("rock"));
    }
}
