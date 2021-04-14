package com.company;

public class Spiel {
    public int anzahlSpieler;
    private Spieler spieler1;   //Spieler deklarieren       ! spieler0 = Dealer
    private Spieler spieler2;   //max 5 Spieler         besserer Weg dafür??
    private Spieler spieler3;
    private Spieler spieler4;
    private Spieler spieler5;
    private Interface interface1;       //Interface für das Spiel deklarieren

    public Spiel(int anzahlSpieler) {
        this.anzahlSpieler = anzahlSpieler;
        interface1 = new Interface();           //Interface erzeugen
        Spielstart();
        debug();

    }


    public void Spielstart() {          //Initialisieren des Spiel
        for(int i=0;i<anzahlSpieler;i++) {      //Spieler erzeugen
           spieler1 = new Spieler(interface1.Einsatz(i));
           //
        }

    }
    public void debug() {
        interface1.ShowEinsatz(spieler1.getEinsatz(), 1);

    }

}
