package com.company;
import java.util.ArrayList;

public class Spiel {
    private int anzahlSpieler;
    private Dealer dealer0;                             //Dealer deklarieren
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
        SpielMitte();
        SpielEnde();
        //debug();

    }
    public int getBlätter() {
        return Blätter;
    }

    public void Spielstart() {                  //Initialisieren des Spiel
        for(int i=0;i<anzahlSpieler;i++) {      //Spieler erzeugen
            Player.add(new Spieler(interface1.Einsatz(i)));

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
        for(int i=0;i<anzahlSpieler;i++)
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
        int[][] Handwerte = Auswertung2();
        boolean stop = false;
        for(int i=0;i<Player.size();i++) {      //Nach BlackJack schauen: Gewinn
           if(CheckBlackJack(i)==true&&(getHandWert(i)<=21)) {
               setEinsatz(getEinsatz(i) * 2.5, i);
               stop = true;
           }
        }

        if(dealer0.BlackJackDetektor()==true&&dealer0.handWert()<=21) {     //Wenn Dealer einen BlackJack hat
            //Pech gehabt
            for(int i=0;i<Player.size();i++) {      //Nach BlackJack schauen
                if (CheckBlackJack(i) == false) {
                    setEinsatz(0,i);            //Alles verloren
                }
            }
        }
        else if(stop==false){      //Wenn er keinen hat: Nach Wert schauen
            if(dealer0.handWert()>Handwerte[Player.size()-1][1]&&dealer0.handWert()<=21) {        //Wenn der Dealer höher ist: alle verlieren
                for(int i=0;i<Player.size();i++) {
                    setEinsatz(0,i);
                }
            }
            else if(dealer0.handWert()<=21) {          //Wenn der Spieler höher ist
                for(int i=0;i<Player.size();i++) {          //alle Spieler durchgehen
                    if(dealer0.handWert()>Handwerte[Player.size()-1][1]) {
                        int spieler = Handwerte[0][0];
                        setEinsatz(getEinsatz(spieler)*2,spieler);
                    }
                    else if(dealer0.handWert()>Handwerte[Player.size()-1][1]) {
                        int spieler = Handwerte[0][0];
                        setEinsatz(0,spieler);
                    }
                    else if(dealer0.handWert()==Handwerte[Player.size()-1][1]) {
                        //nichts
                    }
                }
            }
        }
        else if(stop==true) {           //Wenn es einen BlackJack gibt haben alle anderen verloren
            for(int i=0;i<Player.size();i++) {      //Nach BlackJack schauen
                if (CheckBlackJack(i) == false) {
                    setEinsatz(0, i);            //Alles verloren
                }
            }
        }
        else if(dealer0.handWert()>21&&stop==false) {
            for(int i=0;i<Player.size();i++) {
                if(getHandWert(i)<=21) {
                    setEinsatz(getEinsatz(i)*2,i);
                }
                else {
                    setEinsatz(0,i);
                }
            }
        }
        for(int i=0;i<Player.size();i++) {      //Einsatz für alle Spieler anzeigen
            interface1.ShowEinsatz(getEinsatz(i),i);
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


    public int[][] Auswertung2(){

        int [] [ ] Handwerte = new int[Player.size()] [2];
        for(int i=0;i<Player.size();i++)    //HandWerte der Spieler in ein Array stecken mit Spielernummer
        {
            Handwerte[i] [1] = getHandWert(i);
            Handwerte[i] [0] = i;
        }

        Handwerte =sortiere(Handwerte);
        return Handwerte;
    }
    public int[][] sortiere(int[][] liste) {                //Bubble Sort sortierer
        for (int z = liste.length; z > 1; z = z - 1) {
            for (int i = 0; i < liste.length - 1; i++) {
                if (liste[i][1] > liste[i+1][1]) {                           //vertausche:
                    int hilf = liste[i][1];
                    int hilfS = liste[i][0];
                    liste[i][1] = liste[i+1][1];
                    liste[i][0] = liste[i+1][0];
                    liste[i+1][1] = hilf;
                    liste[i+1][0] = hilfS;
                }
            }
        }
        return liste;
    }
    public void debug() {                               //pls ignorieren
        Karte karte1 = new Karte(1,false);
        Karte karte2 = new Karte(4,false);
        Spieler spieler1 = new Spieler(0);
        spieler1.updateHandBlatt(karte1);
        spieler1.updateHandBlatt(karte2);
        System.out.println(spieler1.handWert());
    }



}
