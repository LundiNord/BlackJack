package com.company;

public class KartenStapel {          //Der Kartenstapel, bestehend aus 6 Decks mit je 52 Karten
    private int Blätter;             //Anzahl der Blätter mit denen gespielt wird
    private int a;                   //Variable zum Sichern der generierten Karte
    private int W1;             //Wahrscheinlichkeiten
    private int W2;
    private int W3;
    private int W4;
    private int W5;
    private int W6;
    private int W7;
    private int W8;
    private int W9;
    private int W10;
    private int W11;

    //ToDo: Array oder ähnliches um Kartenstapel zu Speichern

    public KartenStapel(int Blätter) {
        this.Blätter = Blätter;
        W1 = 4*Blätter;             //Wahrscheinlichkeiten
        W2 = 8*Blätter;
        W3 = 12*Blätter;
        W4 = 16*Blätter;
        W5 = 20*Blätter;
        W6 = 24*Blätter;
        W7 = 28*Blätter;
        W8 = 32*Blätter;
        W9 = 44*Blätter;
        W10 = 48*Blätter;
        W11 = 52*Blätter;

        //ToDo: am Anfang: Kartenstapel mischen uns speichern

    }

    public Karte KarteErzeugen() {
        int[] Karten = new int[12];      //Array mit den Kartenwerten
        Karten[1] = 2;
        Karten[2] = 3;
        Karten[3] = 4;
        Karten[4] = 5;
        Karten[5] = 6;
        Karten[6] = 7;
        Karten[7] = 8;
        Karten[8] = 9;
        Karten[9] = 10;
        Karten[10] = 1;                    //Ass
        Karten[11] = 12;                  //Bube als 12, muss erkannt werden
        int x = new java.util.Random().nextInt(52);

        boolean istBube=false;

        if (x <= W1) {
            a = Karten[1];
            W1 = W1 * Blätter - 1;
        }
        if (x <= W2 && x > 4*Blätter) {
            a = Karten[2];
            W2 = W2 * Blätter - 1;
        }
        if (x <= W3 && x > 8*Blätter) {
            a = Karten[3];
            W3 = W3 * Blätter - 1;
        }
        if (x <= W4 && x > 12*Blätter) {
            a = Karten[4];
            W4 = W4 * Blätter - 1;
        }
        if (x <= W5 && x > 16*Blätter) {
            a = Karten[5];
            W5 = W5 * Blätter - 1;
        }
        if (x <= W6 && x > 20*Blätter) {
            a = Karten[6];
            W6 = W6 * Blätter - 1;
        }
        if (x <= W7 && x > 20*Blätter) {
            a = Karten[7];
            W7 = W7 * Blätter - 1;
        }
        if (x <= W8 && x > 28*Blätter) {
            a = Karten[8];
            W8 = W8 * Blätter - 1;
        }
        if (x <= W9 && x > 32*Blätter) {
            a = Karten[9];
            W9 = W9 * Blätter - 1;
        }
        if (x <= W10 && x > 44*Blätter) {
            a = Karten[11];             //muss noch auf fallsAss() verweisen
            W9 = W9 * Blätter - 1;
        }
        if (x <= W11 && x > 48*Blätter) {
            a = Karten[11];            //muss noch auf Bube() verweisen
            W11 = W11 * Blätter - 1;
            istBube=true;
        }
        if(istBube=true) {
            a = 10;
        }


        Karte karte1 = new Karte(a,istBube);
        return karte1;

    }
    public Karte KarteZiehen() {
        //ToDo: Random Karte auswählen und zurückgeben.


            return null;
        }


}
