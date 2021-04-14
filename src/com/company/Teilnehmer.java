package com.company;
import java.util.ArrayList;

public abstract class Teilnehmer {               //Unterklassen: Spieler, Dealer
    private ArrayList HandBlatt = new ArrayList();      //Array Liste mit den Karten auf der Hand
    public Teilnehmer() {

    }

    public ArrayList getHandBlatt() {
        return HandBlatt;
    }
    public void updateHandBlatt(Karte neueKarte) {      //Hinzufügen neuer Karten
        HandBlatt.add(neueKarte);
    }


    public int handWert() {         //Berechnet den gesamtwert der Karten
        int x;
        int g = HandBlatt.size();
        //
        //auf das Ass aufpassen

        return 7;
    }

}
