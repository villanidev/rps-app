package br.com.villadev.rps.presentation;

import br.com.villadev.rps.core.gamestate.RPSStateMachine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GameController {

    private static final Logger log = LoggerFactory.getLogger(GameController.class);

    public void listenUserInput(final InputStream inputStream) throws IOException {
        log.debug("Listening user input");
        new RPSStateMachine().startMachine(new BufferedReader(new InputStreamReader(inputStream)));
    }
}
