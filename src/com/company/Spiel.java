package com.company;

public class Spiel {
    public int anzahlSpieler;
    private Dealer dealer1;     //Dealer deklarieren
    private Spieler spieler1;   //Spieler deklarieren
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

        }

    }
    public void debug() {
        interface1.ShowEinsatz(spieler1.getEinsatz(), 1);

    }

    public Karte KartenErzeugen() {
        int x =  new java.util.Random().nextInt(53);    //hoffe das 53 richtig ist
        int wert;
        if(x<=16) {             //hässlich      geht das besser??
            wert = 10;
        }
        else if(16<x&&x<=20) {

        }

        Karte karte1 = new Karte(4);        //Karte mit x als Wert erzeugen
        return karte1;
    }

}
