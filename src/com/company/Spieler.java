package com.company;
import java.util.ArrayList;
public class Spieler {
    private ArrayList HandBlatt = new ArrayList();      //Array Liste mit den Karten auf der Hand
    private double einsatz;

    public Spieler(double einsatz)
    {
        this.einsatz = einsatz;
    }
    public ArrayList getHandBlatt() {
        return HandBlatt;
    }
    public void updateHandBlatt(Karte neueKarte) {      //Hinzufügen neuer Karten
        HandBlatt.add(neueKarte);
    }

    public double getEinsatz() {
        return einsatz;
    }

    public void setEinsatz(double einsatz) {
        this.einsatz = einsatz;
    }

    public int handWert() {         //Berechnet den gesamtwert der Karten
        int x;
        int g = HandBlatt.size();
        //Wert ausrechnen


        return 7;
    }
}