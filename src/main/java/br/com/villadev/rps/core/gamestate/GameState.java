package br.com.villadev.rps.core.gamestate;

import java.io.BufferedReader;
import java.io.IOException;

abstract class GameState {

    static GameState welcomeState;

    static GameState helpState;

    static GameState exitGameState;

    static GameState matchState;

    static GameState replayState;

    static GameState current;

    abstract void printStatus();
    abstract void handleRequest(final BufferedReader reader) throws IOException;
}