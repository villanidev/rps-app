package br.com.villadev.rps.core.gamestate;

import java.io.BufferedReader;

class HelpGameState extends GameState {
    @Override
    void printStatus() {
        System.out.println("in HelpState");
    }

    @Override
    void handleRequest(final BufferedReader reader) {
        System.out.println("""
                Paper-Rock-Scissors is a game for two players.\s
                Each player simultaneously chooses a role to play:
                • rock
                • paper
                • scissors
                The winner is determined by the following schema:
                • Paper beats (wraps) rock
                • Rock beats (blunts) scissors
                • Scissors beats (cuts) paper
                """);
        current = welcomeState;
    }
}
