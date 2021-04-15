package com.company;
import java.util.ArrayList;
import java.lang.Math;

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
        int x = 0;          //Wert
        double a = 0;          //Anzahl Asse
        int g = HandBlatt.size();
        for(int i=0;i<g;i++) {
            Karte karte1 = (Karte) HandBlatt.get(i);
            x = x + karte1.getWert();
            if(karte1.istAss()==true) {     //Anzahl der Asse zählen
                a = a+1;
            }
        }
        //ToDo: Was mit den Assen?
        if(a>0) {           //Sich um Asse kümmern
           x = AssHändler(x,a);
        }
        return x;
    }
    public int AssHändler(int wert, double anzahlAsse) {       //Alle kombinationen durchrechnen und beste Auswählen
        wert = (int) (wert-anzahlAsse);
        int x = (int) Math.pow(2,anzahlAsse);
        for (int i = 0; i < anzahlAsse; i++) {



        }



        return wert;
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
