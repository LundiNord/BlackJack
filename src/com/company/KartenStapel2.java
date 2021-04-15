package com.company;

public class KartenStapel2 {

    private int blätter;             //Anzahl der Blätter mit denen gespielt wird
    int[]karten = new int[12];


    public KartenStapel2(int blätter) {
        this.blätter = blätter;

        for(int i=0;i<=12;i++) {
            karten[i] = 4*blätter;
        }
    }

    public Karte KarteErzeugen() {
        boolean istBube = false;
        int x = new java.util.Random().nextInt(13);
        while(karten[x]==0) {
            x = new java.util.Random().nextInt(13);
        }
        karten[x] = karten[x] -1;
        x = x+1;        //es gibt keine Karte 0
        if(x==11) {
            istBube=true;
        }
        if(x==11||x==12||x==13) {
            x = 10;
        }

        Karte karte1 = new Karte(x,istBube);
        return karte1;
    }
}
