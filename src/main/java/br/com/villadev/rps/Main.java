package br.com.villadev.rps;

import br.com.villadev.rps.presentation.GameController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            log.debug("Starting Rock, paper, Scissors game application");
            GameController gameController = new GameController();
            gameController.listenUserInput(System.in);
        } catch (Exception e) {
            log.error("Error while running the application", e);
        }
    }
}