package br.com.villadev.rps.core.gamestate;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class GameState {

    /**
     * Print current state's status to the console.
     */
    public abstract void printStatus();

    /**
     * Handle user input and return the next state. If null is returned, the game should terminate.
     */
    public abstract GameState handleRequest(final BufferedReader reader) throws IOException;
}