package br.com.villadev.rps.core.gamestate;

import java.io.BufferedReader;
import java.util.SplittableRandom;

/**
 * Holds runtime dependencies and configuration for the game loop.
 */
public class GameContext {

    private final BufferedReader reader;
    private final SplittableRandom random;
    private final int defaultRounds;

    public GameContext(BufferedReader reader, SplittableRandom random, int defaultRounds) {
        this.reader = reader;
        this.random = random;
        this.defaultRounds = defaultRounds;
    }

    public GameContext(BufferedReader reader, long seed, int defaultRounds) {
        this(reader, new SplittableRandom(seed), defaultRounds);
    }

    public GameContext(BufferedReader reader, int defaultRounds) {
        this(reader, new SplittableRandom(), defaultRounds);
    }

    public BufferedReader getReader() {
        return reader;
    }

    public SplittableRandom getRandom() {
        return random;
    }

    public int getDefaultRounds() {
        return defaultRounds;
    }
}
