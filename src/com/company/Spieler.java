package com.company;

public class Spieler extends Teilnehmer{

    private double einsatz;     //Spieler haben einsätze

    public Spieler(double einsatz)
    {
        this.einsatz = einsatz;
    }

    public double getEinsatz() {
        return einsatz;
    }
    public void setEinsatz(double einsatz) {
        this.einsatz = einsatz;
    }


}