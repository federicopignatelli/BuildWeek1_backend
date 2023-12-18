package org.example.Entities;

public enum Tipologia {
    FISICO,
    AUTOMATICO;

    static Tipologia getName(String name) {
        return switch (name) {
            case "FISICO" -> FISICO;
            case "AUTOMATICO"-> AUTOMATICO;
            default -> throw new IllegalStateException("Unexpected value: " + name);
        };
    }
}
