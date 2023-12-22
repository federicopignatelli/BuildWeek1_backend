package org.example.Entities;

public enum MezzoType {
    TRAM,
    AUTOBUS;

    public static MezzoType getName(String name) {
        return switch (name) {
            case "TRAM" -> TRAM;
            case "AUTOBUS" -> AUTOBUS;
            default -> throw new IllegalStateException("Unexpected value: " + name);
        };
    }
}
