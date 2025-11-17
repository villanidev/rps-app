package br.com.villadev.rps.core.entities;

public class Rock implements PlayerRole {
    @Override
    public String alias() {
        return "rock";
    }

    @Override
    public String value() {
        return "1";
    }
}
