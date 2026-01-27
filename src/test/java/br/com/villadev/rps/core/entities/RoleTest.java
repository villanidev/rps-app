package br.com.villadev.rps.core.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void alias_and_value_match_spec() {
        assertEquals("rock", Role.ROCK.alias());
        assertEquals("1", Role.ROCK.value());
        assertEquals("paper", Role.PAPER.alias());
        assertEquals("2", Role.PAPER.value());
        assertEquals("scissors", Role.SCISSORS.alias());
        assertEquals("3", Role.SCISSORS.value());
    }

    @Test
    void fromNumber_maps_correctly() {
        assertEquals(Role.ROCK, Role.fromNumber("1"));
        assertEquals(Role.PAPER, Role.fromNumber("2"));
        assertEquals(Role.SCISSORS, Role.fromNumber("3"));
        assertNull(Role.fromNumber("4"));
        assertNull(Role.fromNumber(null));
    }

    @Test
    void fromAlias_maps_case_insensitive() {
        assertEquals(Role.ROCK, Role.fromAlias("rock"));
        assertEquals(Role.ROCK, Role.fromAlias(" ROCK "));
        assertEquals(Role.PAPER, Role.fromAlias("Paper"));
        assertEquals(Role.SCISSORS, Role.fromAlias("SCISSORS"));
        assertNull(Role.fromAlias("lizard"));
        assertNull(Role.fromAlias(null));
    }
}
