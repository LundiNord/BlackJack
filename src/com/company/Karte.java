package com.company;

public class Karte
{
    private int wert;   //Ass=1, Zahlen = 1-10, Bild=10

    private boolean istAss = false;
    private boolean istBube= false;
    public Karte(int wert, boolean istBube) //Karten mit Werten implementieren
    {
        this.istBube = istBube;
        this.wert = wert;
        if(wert==1) {       //Asse vieleicht extra behandeln
            istAss = true;
        }
    }
    public void setWert(int wert) {     //setter
        this.wert = wert;
    }
    public int getWert() {      //getter
        return wert;
    }
}