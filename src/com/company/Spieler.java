package com.company;
import java.util.ArrayList;
public class Spieler {
    private ArrayList HandBlatt = new ArrayList();      //Array Liste mit den Karten auf der Hand
    public Spieler()
    {
        //stuff
    }
    public ArrayList getHandBlatt() {
        return HandBlatt;
    }
}