package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerInterface
{
    public ManagerInterface() {
        System.out.println("Willkommen bei BlackJack");
    }

    public double Einsatz(int spieler) {        //Der wievielte Spieler wird erzeugt ! 0=1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spieler"+spieler+": Wie hoch soll dein Einsatz sein?");
        double x = scanner.nextDouble();
        //Typprüfung notwendig??
        return x;

    }

    public int Blätter(int Blätter){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Blätter möchtest du?"+Blätter);
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

    public int Spielerabfrage(int spielerAnzahl){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Spieler seid ihr/du?");
        int x = scanner.nextInt();
        //Typprüfung notwendig??
        return x;
    }

}