package br.com.villadev.rps.core.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {

    private final GameEngine engine = new GameEngine();

    @Test
    void decide_returns_tie_when_same_role() {
        assertEquals(Outcome.TIE, engine.decide("rock", "rock"));
        assertEquals(Outcome.TIE, engine.decide("paper", "paper"));
        assertEquals(Outcome.TIE, engine.decide("scissors", "scissors"));
    }

    @Test
    void decide_identifies_user_wins() {
        assertEquals(Outcome.USER_WIN, engine.decide("rock", "scissors"));
        assertEquals(Outcome.USER_WIN, engine.decide("paper", "rock"));
        assertEquals(Outcome.USER_WIN, engine.decide("scissors", "paper"));
    }

    @Test
    void decide_identifies_computer_wins() {
        assertEquals(Outcome.COMPUTER_WIN, engine.decide("rock", "paper"));
        assertEquals(Outcome.COMPUTER_WIN, engine.decide("paper", "scissors"));
        assertEquals(Outcome.COMPUTER_WIN, engine.decide("scissors", "rock"));
    }

    @Test
    void toHumanMessage_maps_outcomes() {
        assertEquals("Nobody, it's a tie!", engine.toHumanMessage(Outcome.TIE));
        assertEquals("You won!", engine.toHumanMessage(Outcome.USER_WIN));
        assertEquals("Computer won!", engine.toHumanMessage(Outcome.COMPUTER_WIN));
    }

    @Test
    void isFinished_checks_round_limits() {
        assertFalse(engine.isFinished(0, 3));
        assertFalse(engine.isFinished(2, 3));
        assertTrue(engine.isFinished(3, 3));
        assertTrue(engine.isFinished(4, 3));
    }
}
