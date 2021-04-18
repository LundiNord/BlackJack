package com.company;
import java.util.ArrayList;

public class Management {     //Management um mehrere Runden zu spielen
    //ToDo: Weg um Spieler zu speichern
    private ArrayList Player = new ArrayList();
    private ManagerInterface mInterface1;

    public Management ()
    {

    }

    public void spielerGenerieren(int anzahlSpieler) {

        for(int i=0;i<anzahlSpieler;i++) {      //Spieler erzeugen
            Player.add(new Spieler(mInterface1.Einsatz(i)));
        }

    }

    
}
