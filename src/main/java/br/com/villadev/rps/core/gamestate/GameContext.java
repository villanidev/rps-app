package br.com.villadev.rps.core.gamestate;

import java.io.BufferedReader;
import java.util.Random;

/**
 * Holds runtime dependencies and configuration for the game loop.
 */
public class GameContext {

    private final BufferedReader reader;
    private final Random random;
    private final int defaultRounds;

    public GameContext(BufferedReader reader, Random random, int defaultRounds) {
        this.reader = reader;
        this.random = random;
        this.defaultRounds = defaultRounds;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public Random getRandom() {
        return random;
    }

    public int getDefaultRounds() {
        return defaultRounds;
    }
}
