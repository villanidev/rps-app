package br.com.villadev.rps.presentation;

import java.util.List;

public enum GameMenu {
    WELCOME_OPTION("""
            Welcome to Rock, Paper, Scissors
            Choose below options to start:
            """, List.of(
            new MenuItem("1", "Help"),
            new MenuItem("2", "Start game"),
            new MenuItem("3", "Exit game"))),
    PLAYER_ROLE_OPTION("""
            Now, select your role and let´s play!
            Choose options below to play:
            """, List.of(
            new MenuItem("1", "Rock"),
            new MenuItem("2", "Paper"),
            new MenuItem("3", "Scissors"))),
    REPLAY_OPTION("Do you want to play it again?", List.of(
            new MenuItem("1", "Yes"),
            new MenuItem("2", "No")
    ));

    GameMenu(String description, List<MenuItem> options) {
        this.description = description;
        this.options = options;
    }

    private String description;
    private List<MenuItem> options;

    public String getDescription() {
        return description;
    }

    public List<MenuItem> getOptions() {
        return options;
    }
}
