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


    public int handWert() {         //Berechnet den gesamtwert der Karten auf der Hand
        int x = 0;
        int g = HandBlatt.size();
        for(int i=0;i<g;i++) {
            Karte karte1 = (Karte) HandBlatt.get(i);
            x = x + karte1.getWert();
        }
        //ToDo: Was mit den Assen
        return x;
    }
    public boolean BlackJackDetektor() {        //true: BlackJack vorhanden
        boolean vorhanden = false;
        boolean Ass = false;
        boolean Bube = false;
        //ToDo: Ass+Bube erkennen
        for(int i=0;i<HandBlatt.size();i++) {
            Karte karte1 = (Karte) HandBlatt.get(i);
            if(Ass==false) {                        //Überschreibungen des Ergebnisses verhindern
                Ass = karte1.istAss();
            }
            if(Bube==false) {
                Bube = karte1.istBube();
            }
        }
        if(Ass==true&&Bube==true) {     //Nur wenn beide true sind
            vorhanden = true;
        }
        return vorhanden;
    }

}
