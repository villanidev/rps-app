package br.com.villadev.rps.core.entities;

import java.util.Locale;

public enum Role implements PlayerRole {
    ROCK("rock", "1"),
    PAPER("paper", "2"),
    SCISSORS("scissors", "3");

    private final String alias;
    private final String value;

    Role(String alias, String value) {
        this.alias = alias;
        this.value = value;
    }

    @Override
    public String alias() {
        return alias;
    }

    @Override
    public String value() {
        return value;
    }

    public static Role fromNumber(String number) {
        if (number == null) return null;
        return switch (number) {
            case "1" -> ROCK;
            case "2" -> PAPER;
            case "3" -> SCISSORS;
            default -> null;
        };
    }

    public static Role fromAlias(String text) {
        if (text == null) return null;
        String t = text.trim().toLowerCase(Locale.ROOT);
        return switch (t) {
            case "rock" -> ROCK;
            case "paper" -> PAPER;
            case "scissors" -> SCISSORS;
            default -> null;
        };
    }
}
