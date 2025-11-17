package br.com.villadev.rps.core.entities;

import java.util.Objects;

public class Player {

    private final String name;
    private PlayerRole role;

    public Player(final String name) {
        this.name = name;
    }

    public void setRole(PlayerRole role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public PlayerRole getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return Objects.equals(name, player.name) && Objects.equals(role, player.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
