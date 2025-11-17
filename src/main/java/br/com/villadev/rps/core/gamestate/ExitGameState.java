package br.com.villadev.rps.core.gamestate;

import java.io.BufferedReader;

class ExitGameState extends GameState {

    @SuppressWarnings("unused")
    ExitGameState(RPSStateMachine machine) {
        // no-op, kept for symmetry with other states
    }
    @Override
    public void printStatus() {
        System.out.println("in ExitGameState");
    }

    @Override
    public GameState handleRequest(final BufferedReader reader) {
        // Signal termination by returning null
        return null;
    }
}
