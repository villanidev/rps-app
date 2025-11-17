package br.com.villadev.rps.core.gamestate;

import java.io.BufferedReader;
import java.io.IOException;

@SuppressWarnings("InfiniteLoopStatement")
public class RPSStateMachine {

    public void startMachine(BufferedReader reader) throws IOException {
        GameState.welcomeState = new WelcomeGameState();
        GameState.helpState = new HelpGameState();
        GameState.exitGameState = new ExitGameState();
        GameState.matchState = new MatchGameState();
        GameState.replayState = new ReplayGameState();

        GameState.current = GameState.welcomeState;

        while (true) {
            GameState.current.printStatus();
            GameState.current.handleRequest(reader);
        }
    }
}
