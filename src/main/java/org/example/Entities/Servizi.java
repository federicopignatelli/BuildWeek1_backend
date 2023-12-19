package org.example.Entities;

public enum Servizi {
    BIGLIETTERIA,
    ABBONAMENTI,
    BOTH;

    static Servizi getName(String name) {
       return switch (name) {
           case "BOTH" -> BOTH;
           case "ABBONAMENTI" -> ABBONAMENTI;
           case "BIGLIETTI" -> BIGLIETTERIA;
           default -> throw new IllegalStateException("Unexpected value: " + name);
       };
   }

}

