package br.com.villadev.rps.core.engine;

public class GameEngine {

    public Outcome decide(String userRole, String computerRole) {
        if (userRole.equals(computerRole)) {
            return Outcome.TIE;
        }
        if (isPlayerWin(userRole, computerRole)) {
            return Outcome.USER_WIN;
        }
        return Outcome.COMPUTER_WIN;
    }

    public boolean isFinished(int roundsPlayed, int totalRounds) {
        return roundsPlayed >= totalRounds;
    }

    public String toHumanMessage(Outcome outcome) {
        return switch (outcome) {
            case TIE -> "Nobody, it's a tie!";
            case USER_WIN -> "You won!";
            case COMPUTER_WIN -> "Computer won!";
        };
    }

    private boolean isPlayerWin(String userRole, String computerRole) {
        return (userRole.equals("rock") && computerRole.equals("scissors"))
                || (userRole.equals("scissors") && computerRole.equals("paper"))
                || (userRole.equals("paper") && computerRole.equals("rock"));
    }
}
