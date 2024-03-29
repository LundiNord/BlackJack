package com.company;
import java.util.ArrayList;

public class Spiel {
    private Dealer dealer0;                             //Dealer deklarieren
    private ArrayList Player = new ArrayList();        //Array List an Spielern |  Startet mit 0
    private Interface interface1;                      //Interface für das Spiel deklarieren
    private KartenStapel2 kartenstapel1;
    private int Blätter;


    public Spiel(int anzahlBlätter, ArrayList Player) {
        interface1 = new Interface();           //Interface erzeugen
        kartenstapel1 = new KartenStapel2(anzahlBlätter);
        this.Player= Player;
    }
    public ArrayList SpielAusführen() {
        Spielstart();
        SpielMitte();
        SpielEnde();
        return Player;
    }
    public int getBlätter() {
        return Blätter;
    }

    public void Spielstart() {                  //Initialisieren des Spiel
        for(int i=0;i< Player.size();i++) {      //Spieler erzeugen
            //setEinsatz(interface1.Einsatz(i),i);
            double x = EinsatzAbziehen(i);      //x ist irrelevant

            addKarten(kartenstapel1.KarteErzeugen(), i);
            addKarten(kartenstapel1.KarteErzeugen(), i);
        }
        //Dealer erzeugen und Startkarten austeilen
        dealer0 = new Dealer();
        Karte karte1 = kartenstapel1.KarteErzeugen();
        dealer0.updateHandBlatt(karte1);
        interface1.showKarteDealer(karte1);
    }
    
    public void SpielMitte() {              //Spieler dürfen mehr Karten ziehen
        for(int i=0;i< Player.size();i++)
        {
            interface1.spielerWechsel(i);
            interface1.showHand(i,getHand(i));
            boolean stop = false;
            while(stop==false&&interface1.KartenFragen(i))
            {
                addKarten(kartenstapel1.KarteErzeugen(), i);
                interface1.showHand(i, getHand(i));
                if(getHandWert(i)>21) {        //Wenn sie zu viel ziehen haben sie verloren
                    stop = true;
                    interface1.verloren(i);
                }
            }
            interface1.showHandwert(i,getHandWert(i));
        }
        //Dealer zieht Karten bis er über 16 ist oder ein BlackJack hat
        while(dealer0.handWert()<17&&dealer0.BlackJackDetektor()==false) {
            Karte karte1 = kartenstapel1.KarteErzeugen();
            dealer0.updateHandBlatt(karte1);
            interface1.showKarteDealer(karte1);
        }
    }
    
    public void SpielEnde() {           //Auswertung des Spieles

        for(int i=0;i<Player.size();i++) {      //Über 21 aussortieren
            if(getHandWert(i)>21) {
                setEinsatz(0,i);
                setHandwertNull(i);
            }
        }

        if(dealer0.BlackJackDetektor()==true&& dealer0.handWert()<= 21) {
            for (int i=0; i<Player.size(); i++) {
                if(CheckBlackJack(i)==true) {
                    // bleibt gleich
                }
                else {
                    setEinsatz(0 , i);
                }
            }
        }
        else if(dealer0.handWert()>=22) {
            for (int i=0; i<Player.size(); i++) {
                if(CheckBlackJack(i)==true) {
                    setEinsatz(getEinsatz(i)*2.5,i);
                }
                else {
                    setEinsatz(getEinsatz(i)*2,i);
                }
            }
        }
        else{
            for (int i=0; i<Player.size(); i++) {
                if(CheckBlackJack(i)==true) {
                    setEinsatz(getEinsatz(i)*2.5,i);
                }
                else if(getHandWert(i)>dealer0.handWert()) {
                    setEinsatz(getEinsatz(i)*2,i);
                }
                else if(getHandWert(i)==dealer0.handWert()) {
                    // nichts passiert
                }
                else if(getHandWert(i)<dealer0.handWert()) {
                    setEinsatz(0,i);
                }
            }
        }
        for(int i=0;i<Player.size();i++) {      //Einsatz für alle Spieler anzeigen
            interface1.ShowEinsatz(getEinsatz(i),i);
            setHandwertNull(i);
        }
    }
    public double EinsatzAbziehen(int spieler){
        double e = interface1.Einsatz(spieler);     //Einsatz erfragen
        Spieler spieler1 = (Spieler)Player.get(spieler);
        double k = spieler1.getKonto();
        if((k-e)<0) {       //Wenn zu hoch, dann warnen und nochmal
            interface1.achtungEinsatz(spieler);
            e = EinsatzAbziehen(spieler);
        }
        spieler1.setKonto(k-e);
        Player.set(spieler,spieler1);
        setEinsatz(e,spieler);
        return e;
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
    public void setEinsatz(double einsatz,int spieler){     //Einsatz in den Spieler schreiben
        Spieler spieler1 = (Spieler) Player.get(spieler);
        spieler1.setEinsatz(einsatz);
        Player.set(spieler,spieler1);

    }
    public int getHandWert(int spieler) {
        Spieler spieler1 = (Spieler) Player.get(spieler);
        return spieler1.handWert();
    }
    public boolean CheckBlackJack(int spieler) {
        Spieler spieler1 = (Spieler) Player.get(spieler);
        return spieler1.BlackJackDetektor();
    }
    public ArrayList getHand(int spieler)
    {
        Spieler spieler1 = (Spieler) Player.get(spieler);
        return spieler1.getHandBlatt();
    }
    public void setHandwertNull(int spieler) {      //Hand Blatt leeren
        Spieler spieler1 = (Spieler) Player.get(spieler);
        spieler1.BlattLeeren();
        Player.set(spieler,spieler1);
    }
}
