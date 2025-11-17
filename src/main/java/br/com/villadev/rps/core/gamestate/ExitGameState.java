package br.com.villadev.rps.core.gamestate;

import java.io.BufferedReader;

class ExitGameState extends GameState {
    @Override
    void printStatus() {
        System.out.println("in ExitGameState");
    }

    @Override
    void handleRequest(final BufferedReader reader) {
        System.exit(1);
    }
}
