package br.com.villadev.rps;

import br.com.villadev.rps.presentation.GameController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            log.info("Starting Rock, Paper, Scissors application");
            GameController gameController = new GameController();
            gameController.listenUserInput(System.in);
            log.info("Application finished");
        } catch (IOException ioe) {
            // I/O issues (e.g., input stream closed) are not necessarily fatal errors in CLI apps
            log.warn("I/O while running the application: {}", ioe.getMessage());
        } catch (Exception e) {
            log.error("Unexpected error while running the application", e);
        }
    }
}