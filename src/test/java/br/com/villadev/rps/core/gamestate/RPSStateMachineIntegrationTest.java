package br.com.villadev.rps.core.gamestate;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class RPSStateMachineIntegrationTest {

    @Test
    void welcome_to_help_and_back_to_welcome() throws Exception {
        String input = "1\n"; // Welcome: 1 -> Help
        BufferedReader reader = new BufferedReader(new StringReader(input));
        GameContext context = new GameContext(reader, 123L, 3);
        RPSStateMachine machine = new RPSStateMachine(context);

        GameState welcome = machine.getCurrent();
        GameState next = welcome.handleRequest(reader); // to Help
        assertNotNull(next);
        assertNotSame(welcome, next);

        GameState back = next.handleRequest(reader); // Help returns to Welcome
        assertSame(welcome, back);
    }

    @Test
    void full_match_then_exit_via_replay() throws Exception {
        // Welcome: 2 (Start), then rounds prompt: <enter> for default, then 3 rounds Rock (1,1,1), then Replay: 2 (Exit)
        String input = "2\n\n1\n1\n1\n2\n";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        GameContext context = new GameContext(reader, 42L, 3);
        RPSStateMachine machine = new RPSStateMachine(context);

        GameState current = machine.getCurrent();
        int safety = 0;
        while (current != null && safety++ < 20) {
            current = current.handleRequest(reader);
        }
        assertNull(current, "Game should terminate after replay -> exit");
    }

    @Test
    void full_match_with_custom_rounds_then_exit() throws Exception {
        // Welcome: 2 (Start), set custom rounds to 2, play 2 rounds (1,1), Replay: 2 (Exit)
        String input = "2\n2\n1\n1\n2\n";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        GameContext context = new GameContext(reader, 99L, 3);
        RPSStateMachine machine = new RPSStateMachine(context);

        GameState current = machine.getCurrent();
        int safety = 0;
        while (current != null && safety++ < 20) {
            current = current.handleRequest(reader);
        }
        assertNull(current, "Game should terminate after replay -> exit with custom rounds");
    }
}
