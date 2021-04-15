package com.company;

public class KartenStapel2 {

    private int blätter;             //Anzahl der Blätter mit denen gespielt wird
    int[]karten = new int[13];      //Array mit allen möglichen Karten (2,3,...10,Bube,...)

    public KartenStapel2(int blätter) {
        this.blätter = blätter;

        for(int i=0;i<=12;i++) {
            karten[i] = 4*blätter;      //Array mit möglichen Karten füllen
        }
    }

    public Karte KarteErzeugen() {
        boolean istBube = false;
        int x = new java.util.Random().nextInt(13);
        while(karten[x]==0) {
            x = new java.util.Random().nextInt(13);     //Random Karte auswählen, alle haben die gleiche Wahrscheinlichkeit
        }
        karten[x] = karten[x] -1;   //Eine Karte abziehen
        x = x+1;                    //es gibt keine Karte 0
        if(x==11) {                 //Buben extra
            istBube=true;
        }
        if(x==11||x==12||x==13) {   //mehrere Karten mit dem Wert 10
            x = 10;
        }

        Karte karte1 = new Karte(x,istBube);        //Karte ausgeben
        return karte1;
    }
}
