package br.com.villadev.rps.presentation;

import br.com.villadev.rps.core.gamestate.RPSStateMachine;
import br.com.villadev.rps.core.gamestate.GameContext;
import br.com.villadev.rps.core.gamestate.GameState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.SplittableRandom;

public class GameController {

    private static final Logger log = LoggerFactory.getLogger(GameController.class);

    public void listenUserInput(final InputStream inputStream) throws IOException {
        log.info("Game session started. Waiting for user input...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        GameContext context = new GameContext(reader, new SplittableRandom(), 3);
        RPSStateMachine machine = new RPSStateMachine(context);

        boolean running = true;
        while (running) {
            GameState current = machine.getCurrent();
            current.printStatus();
            GameState next = current.handleRequest(reader);
            if (next == null) {
                running = false;
            } else {
                machine.setCurrent(next);
            }
        }
        log.info("Game session ended.");
    }
}
