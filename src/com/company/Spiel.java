package com.company;

public class Spiel {
    public int anzahlSpieler;
    private Spieler spieler1;
    public Spiel(int anzahlSpieler) {
        this.anzahlSpieler = anzahlSpieler;

        Spielstart();

    }

    public Spiel() {
    }

    public void Spielstart() {          //Initialisieren des Spiel
        for(int i=0;i<anzahlSpieler;i++) {
           spieler1 = new Spieler(7);
        }

    }

}
