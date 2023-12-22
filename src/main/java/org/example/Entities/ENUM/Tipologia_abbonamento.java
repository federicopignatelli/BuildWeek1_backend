package org.example.Entities.ENUM;

public enum Tipologia_abbonamento {
    SETTINAMALE,
    MENSILE,
    SEMESTRALE,
    ANNUALE;


    public static Tipologia_abbonamento getTypeAbb(String name){
        return switch (name){
            case "SETTIMANALE"-> SETTINAMALE;
            case "MENSILE"-> MENSILE;
            case "SEMESTRALE"-> SEMESTRALE;
            case "ANNUALE"-> ANNUALE;
            default -> throw new IllegalStateException("Unexpected value: "+name);
        };
    }
}
