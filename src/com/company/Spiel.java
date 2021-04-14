package com.company;

public class Spiel {
    public int anzahlSpieler;
    private Spieler spieler1;
    private Interface interface1;       //Interface für das Spiel erzeugen
    public Spiel(int anzahlSpieler) {
        this.anzahlSpieler = anzahlSpieler;

        Spielstart();

    }

    public Spiel() {
    }

    public void Spielstart() {          //Initialisieren des Spiel
        for(int i=0;i<anzahlSpieler;i++) {      //Spieler erzeugen
           spieler1 = new Spieler(interface1.Einsatz());
        }

    }

}
