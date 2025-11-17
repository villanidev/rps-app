package br.com.villadev.rps.core.entities;

public class Paper implements PlayerRole {
    @Override
    public String alias() {
        return "paper";
    }

    @Override
    public String value() {
        return "2";
    }
}
