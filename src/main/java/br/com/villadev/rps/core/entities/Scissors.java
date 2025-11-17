package br.com.villadev.rps.core.entities;

public class Scissors implements PlayerRole {
    @Override
    public String alias() {
        return "scissors";
    }

    @Override
    public String value() {
        return "3";
    }
}
