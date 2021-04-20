package com.company;

public class Spieler extends Teilnehmer{

    private double einsatz;     //Spieler haben einsätze
    private double konto;       //Konto des Spielers

    public Spieler(double konto)
    {
        this.konto = konto;
    }

    public double getEinsatz() {
        return einsatz;
    }
    public void setEinsatz(double einsatz) {
        this.einsatz = einsatz;
    }

    public double getKonto() {
        return konto;
    }

    public void setKonto(double konto) {
        this.konto = konto;
    }
    public void Einzahlung(int x){
        konto= konto+x;
    }
}