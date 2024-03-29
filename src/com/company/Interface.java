package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Interface {
    public Interface() {
        System.out.println("Willkommen bei BlackJack");
    }
    public double Einsatz(int spieler) {        //Der wievielte Spieler wird erzeugt ! 0=1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spieler"+spieler+": Wie hoch soll dein Einsatz sein?");
        double x = scanner.nextDouble();
            if(x<1){
            x= Einsatz(spieler);
        }
        return x;
    }
    public void ShowEinsatz(double einsatz, int spieler) {
        System.out.println("Spieler"+spieler+": Dein verbleibender Einsatz ist: "+einsatz);
    }
    public boolean KartenFragen(int spieler){       //Spieler fragen ob sie neue Karten möchten
        boolean Ja = false;
        System.out.println("Spieler"+spieler+": Möchtest du eine neue Karte ziehen? J/N");
        Scanner scanner = new Scanner(System.in);
        char x = scanner.next().charAt(0);
        if(x=='J'||x=='j'){
            Ja=true;
        }
        else if(x=='N'||x=='n'){
            Ja=false;
        }
        else {              //Nur j/n erlauben
            Ja = KartenFragen(spieler);
        }
        return Ja;
    }
    public void showKarteDealer(Karte karte1) {               //Karte des Dealers anzeigen
        int wert = karte1.getWert();
        boolean istBube = karte1.istBube();
        System.out.println("Der Dealer hat eine offene Karte gezogen:");
        System.out.println("Ihr Wert ist: "+wert);
        if(istBube==true) {
            System.out.println("    Sie ist ein Bube");
        }
        else if(wert==1) {
            System.out.println("    Sie ist ein Ass");
        }
    }
    public void showHand(int spieler, ArrayList Hand){              //gibt alle Karten auf der Hand aus
        for(int i=0;i<Hand.size();i++){
            Karte karte1 =(Karte) Hand.get(i);
            int x= karte1.getWert();
            boolean istBube=karte1.istBube();
            System.out.println("Spieler"+spieler+": du hast diese Karte auf der Hand:"+x);
            if(istBube==true) {
                System.out.println("    Es ist ein Bube.");
            }
            if(x==1) {
                System.out.println("    Es ist ein Ass.");
            }
        }
    }
    public void showHandwert(int spieler, int Handwert){ //throws InterruptedException
        System.out.println("Spieler"+spieler+": Dein Handwert ist: "+Handwert);
    }
    public void verloren(int spieler) {
        System.out.println("Spieler"+spieler+": Du hast verloren");
    }
    public void spielerWechsel(int nspieler) {          //Spieler wechseln
        System.out.println("---------");
        System.out.println("Jetzt ist Spieler "+nspieler+" dran. Bitte wegschauen!");
        System.out.println("---------");
        wait(4000);
    }
    public static void wait(int ms)     //Warten methode
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    public void achtungEinsatz(int spieler) {
        System.out.println("Spieler"+spieler+": Der Einsatz ist zu hoch für dein Konto. Bitte wähle einen niedrigeren.");
    }
}