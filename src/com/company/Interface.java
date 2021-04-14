package com.company;
import java.util.Scanner;

public class Interface {
    public Interface() {
        System.out.println("Willkommen bei BlackJack");
    }

    public double Einsatz(int spieler) {        //Der wievielte Spieler wird erzeugt ! 0=1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spieler: "+spieler+"Wie hoch soll dein Einsatz sein?");
        int x = scanner.nextInt();
        //Typprüfung notwendig??
        return x;
    }
    public void ShowEinsatz(double einsatz, int spieler) {
        System.out.println("Spieler: "+spieler+" | Dein Einsatz: "+einsatz);
    }
}
