package com.company;
import java.util.ArrayList;

public class Spiel {
    private int anzahlSpieler;
    private Dealer dealer1;                             //Dealer deklarieren
    private ArrayList Player = new ArrayList();        //Array List an Spielern |  Startet mit 0
    private Interface interface1;                      //Interface für das Spiel deklarieren
    private KartenStapel2 kartenstapel1;
    private int Blätter;

    public Spiel(int anzahlSpieler) {
        this.anzahlSpieler = anzahlSpieler;
        interface1 = new Interface();           //Interface erzeugen
        kartenstapel1 = new KartenStapel2(1);

        //Nur zum Testen
        Spielstart();
        debug();

    }
    public int getBlätter() {
        return Blätter;
    }

    public void Spielstart() {          //Initialisieren des Spiel
        for(int i=0;i<anzahlSpieler;i++) {      //Spieler erzeugen
            Player.add(new Spieler(interface1.Einsatz(i)));


            for(int s=0;s<52;s++){
                addKarten(kartenstapel1.KarteErzeugen(), i);
            }

        }

    }
    public void addKarten(Karte karte1, int spieler) {      //Karten in ein Karten Array eines Spielers einfügen
        Spieler spieler1 = (Spieler) Player.get(spieler);
        spieler1.updateHandBlatt(karte1);
        Player.set(spieler,spieler1);
    }
    public double getEinsatz(int spieler) {                 //Einsatz eines Spielers bekommen
        Spieler spieler1 = (Spieler) Player.get(spieler);
        return spieler1.getEinsatz();
    }
    public int getHandWert(int spieler) {
        Spieler spieler1 = (Spieler) Player.get(spieler);
        return spieler1.handWert();
    }
    public boolean CheckBlackJack(int spieler) {
        Spieler spieler1 = (Spieler) Player.get(spieler);
        return spieler1.BlackJackDetektor();
    }
    //ToDo: weitere Variablen aus der Array List Player bekommen
    //wahrscheinlich geht das besser, weiß aber nicht wie



    public void debug() {                               //pls ignorieren
        interface1.ShowEinsatz(getEinsatz(0),0);

        System.out.println("Hand Wert: "+getHandWert(0));
        System.out.println("BlackJack: "+CheckBlackJack(0));


    }



}


