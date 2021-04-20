package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerInterface
{
    public ManagerInterface() {
        System.out.println("Willkommen bei BlackJack");
    }

    public double Konto(int spieler) {        //Der wievielte Spieler wird erzeugt ! 0=1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spieler"+spieler+": Wie viel Geld soll auf dein Konto?");
        double x = scanner.nextDouble();
        //Typprüfung notwendig??
        return x;

    }

    public int Blätterabfrage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Blätter möchtest du?");
        int x = scanner.nextInt();
        //Typprüfung notwendig??
        return x;
    }

    public void spielerWechsel(int nspieler) {          //Spieler wechseln
        System.out.println("---------");
        System.out.println("Jetzt ist Spieler " + nspieler + " dran. Bitte wegschauen!");
        System.out.println("---------");
        //ToDo: Wartezeit
        //Thread.sleep(1000);
    }

    public int Spielerabfrage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Spieler seid ihr/du?");
        int x = scanner.nextInt();
        //Typprüfung notwendig??
        return x;
    }

    public boolean NeueRunde(){
        boolean Ja = false;
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("Möchtet ihr eine neue Runde spielen? J/N");
        Scanner scanner = new Scanner(System.in);
        char x = scanner.next().charAt(0);
        if(x=='J'||x=='j'){
            Ja=true;
        }
        else if(x=='N'||x=='n'){
            Ja=false;
        }
        else {              //Nur j/n erlauben
            Ja = NeueRunde();
        }
        return Ja;
    }
    public void KontostandAusgeben(int spieler, double Kontostand){
        System.out.println("Spieler"+spieler+": Dein Kontostand ist:"+Kontostand);
    }
    public boolean mehrGeld(){
        boolean Ja = false;
        System.out.println("Möchte jemand Geld auf sein Konto einzahlen? J/N");
        Scanner scanner = new Scanner(System.in);
        char x = scanner.next().charAt(0);
        if(x=='J'||x=='j'){
            Ja=true;
        }
        else if(x=='N'||x=='n'){
            Ja=false;
        }
        else {              //Nur j/n erlauben
            Ja = NeueRunde();
        }
        return Ja;
    }
    public int einzahlung(int spieler){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spieler"+spieler+": Wie willst du einzahlen?");
        int x = scanner.nextInt();
        //Typprüfung notwendig??
        return x;
    }

}