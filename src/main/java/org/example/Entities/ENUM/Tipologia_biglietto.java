package org.example.Entities.ENUM;

public enum Tipologia_biglietto {
    SESSANTAMINUTI,
    NOVANTAMINUTI,

    GIORNALIERO,
    CENTOVENTIMINUTI;


    public static Tipologia_biglietto getType(String name){
        return switch (name){
            case "GIORNALIERO"-> GIORNALIERO;
            case "SESSANTAMINUTI"-> SESSANTAMINUTI;
            case "NOVANTAMINUTI"-> NOVANTAMINUTI;
            case "CENTOVENTIMINUTI"-> CENTOVENTIMINUTI;
            default -> throw new IllegalStateException("Unexpected value: "+name);
        };
    }
}
