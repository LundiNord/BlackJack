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
       int[] Karten= new int [11];      //Array mit den Kartenwerten
       Karten[0]=1;
       Karten[1]=2;
       Karten[2]=3;
       Karten[3]=4;
       Karten[4]=5;
       Karten[5]=6;
       Karten[6]=7;
       Karten[7]=8;
       Karten[8]=9;
       Karten[9]=10;
       Karten[10]=11;
       Karten[11]=12;                  //Bube als 12, muss erkannt werden
       int x =  new java.util.Random().nextInt(52);
       int a;
       if(x<=4){
           a=Karten[1];
       }
       if(x<=8&&x>4){
           a=Karten[2];
        }
       if(x<=12&&x>8){
           a=Karten[3];
       }
       if(x<=16&&x>12){
           a=Karten[4];
       }
       if(x<=20&&x>16){
           a=Karten[5];
       }
       if(x<=24&&x>20){
           a=Karten[6];
       }
       if(x<=28&&x>20) {
           a = Karten[7];
       }
       if(x<=32&&x>28){
           a=Karten[8];
       }
       if(x<=44&&x>32){
           a=Karten[9];
       }
       if(x<=48&&x>44){
           a=Karten[11];             //muss noch auf fallsAss() verweisen
       }
       if(x<=52&&x>48){
           a=Karten[11];            //muss noch auf Bube() verweisen
       }
    }

}
