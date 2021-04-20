package com.company;
import java.util.ArrayList;

public class Management {     //Management um mehrere Runden zu spielen
    //ToDo: Weg um Spieler zu speichern
    private ArrayList Player = new ArrayList();
    private ManagerInterface mInterface1;
    private int Blätter;
    private Spiel spiel1;


    public Management ()
    {
        mInterface1=new ManagerInterface();
        Blätter= mInterface1.Blätterabfrage();
        spielerGenerieren(mInterface1.Spielerabfrage());
        while (mInterface1.NeueRunde()==true){
        Player= spiel1.Spiel(Blätter,Player);
        for(int i=0;i<Player.size();i++){
            Spieler spieler1=(Spieler) Player.get(i);
            mInterface1.KontostandAusgeben(i,spieler1.getKonto());
        }
        if (mInterface1.mehrGeld()==true){
            for(int i=0; i<= Player.size();i++){
                Spieler spieler1=(Spieler) Player.get(i);
                spieler1.Einzahlung(mInterface1.einzahlung(i));
                Player.set(i,spieler1);
            }
        }
        }
    }

    public void spielerGenerieren(int anzahlSpieler) {

        for(int i=0;i<anzahlSpieler;i++) {      //Spieler erzeugen
            Player.add(new Spieler(mInterface1.Konto(i)));
        }
    }

    
}
