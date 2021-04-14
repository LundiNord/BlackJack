package com.company;
import java.util.ArrayList;

public class Spiel {
    private int anzahlSpieler;
    private Dealer dealer1;                             //Dealer deklarieren
    private ArrayList Player = new ArrayList();        //Array List an Spielern
    private Interface interface1;       //Interface für das Spiel deklarieren

    public Spiel(int anzahlSpieler) {
        this.anzahlSpieler = anzahlSpieler;
        interface1 = new Interface();           //Interface erzeugen
        Spielstart();
        debug();

    }


    public void Spielstart() {          //Initialisieren des Spiel
        for(int i=0;i<anzahlSpieler;i++) {      //Spieler erzeugen
            Player.add(new Spieler(interface1.Einsatz(i)));
            //Karte erzeugen und dem Spieler geben
        }

    }
    public void debug() {
        interface1.ShowEinsatz([Player.get(1)].i), 1);
        int i;
        i = [Player(1)].i;
    }

    public Karte KarteErzeugen() {
        int x =  new java.util.Random().nextInt(53);    //hoffe das 53 richtig ist
        int wert;
        if(x<=12) {             //hässlich      geht das besser??
            wert = 10;
        }
        else if(12<x&&x<=16) {      //Bild +
            wert = 2;
        }

        Karte karte1 = new Karte(4, true);        //Karte mit x als Wert erzeugen
        return karte1;
    }

}
