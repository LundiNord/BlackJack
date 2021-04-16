package com.company;
import java.util.Scanner;

public class Interface {
    public Interface() {
        System.out.println("Willkommen bei BlackJack");
    }

    public double Einsatz(int spieler) {        //Der wievielte Spieler wird erzeugt ! 0=1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spieler: "+spieler+" | Wie hoch soll dein Einsatz sein?");
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
    public void ShowEinsatz(double einsatz, int spieler) {
        System.out.println("Spieler: "+spieler+" | Dein Einsatz ist: "+einsatz);
    }

    public void showKarteDealer(Karte karte1) {               //Karte des Dealers anzeigen
        int wert = karte1.getWert();
        boolean istBube = karte1.istBube();
        System.out.println("Der Dealer hat eine offene Karte gezogen:");
        System.out.println("Ihr Wert ist: "+wert);
        if(istBube==true) {
            System.out.println("Sie ist ein Bube");
        }
        if(wert==1) {
            System.out.println("Sie ist ein Ass");
        }

    }
}
