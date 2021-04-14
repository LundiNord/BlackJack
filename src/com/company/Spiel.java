package com.company;

public class Spiel {
    public int anzahlSpieler;
    private Spieler spieler1;           //Spieler deklarieren       ! spieler0 = Dealer
    private Interface interface1;       //Interface für das Spiel deklarieren

    public Spiel(int anzahlSpieler) {
        this.anzahlSpieler = anzahlSpieler;
        interface1 = new Interface();           //Interface erzeugen
        Spielstart();

    }


    public void Spielstart() {          //Initialisieren des Spiel
        for(int i=0;i<=anzahlSpieler;i++) {      //Spieler erzeugen
           spieler1 = new Spieler(interface1.Einsatz(i));
           //
        }

    }

}
