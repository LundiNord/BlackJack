package com.company;
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
             if(x<0){
            x= Konto(spieler);
        }
        return x;

    }
    public int Blätterabfrage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Blätter möchtest du?");
        int x = scanner.nextInt();
            if(x<1){
                x= Blätterabfrage();
            }
            return x;
    }
    public int Spielerabfrage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Spieler seid ihr/du?");
        int x = scanner.nextInt();
            if(x<0){
            x= Spielerabfrage();
        }
        return x;
    }
    public boolean NeueRunde(){
        boolean Ja;
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
        System.out.println("Spieler"+spieler+": Wie viel willst du einzahlen?");
        int x = scanner.nextInt();
            if(x<0){
            x= einzahlung(spieler);
         }
        return x;
    }
    public void SpielerEntfernt(int spieler) {      //Spieler rücken aus
        System.out.println("Der Spieler"+spieler+" wurde entfernt. Spieler"+(spieler+1)+" ist jetzt Spieler"+spieler+".");
    }
    public void Ersteller()  {
        System.out.println("by Jan, Ricardo and Leon");
    }
}