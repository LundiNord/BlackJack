package com.company;
import java.util.ArrayList;

public class Management {     //Management um mehrere Runden zu spielen
    private ArrayList Player = new ArrayList();
    private ManagerInterface mInterface1;
       private int Blätter;
    private Spiel spiel1;


    public Management ()
    {
        mInterface1=new ManagerInterface();
        Blätter= mInterface1.Blätterabfrage();
        spielerGenerieren(mInterface1.Spielerabfrage());
        while (mInterface1.NeueRunde()==true){      //Solange gewünscht wird weiter gespielt
            Spiel();
        }
    }

    public void spielerGenerieren(int anzahlSpieler) {

        for(int i=0;i<anzahlSpieler;i++) {      //Spieler erzeugen
            Player.add(new Spieler(mInterface1.Konto(i)));
        }
    }
    public void Spiel() {           //Das Spiel wird aufgerufen und ausgeführt
        spiel1 = new Spiel(Blätter,Player);
        Player= spiel1.SpielAusführen();
        for(int i=0;i<Player.size();i++){
            Spieler spieler1=(Spieler) Player.get(i);
            spieler1.setKonto(spieler1.getEinsatz() + spieler1.getKonto()); //Einsatz am Ende wieder aufs Konto rechnen
            mInterface1.KontostandAusgeben(i,spieler1.getKonto());  //Kontostand ausgeben
        }
        if (mInterface1.mehrGeld()==true){      //Geld einzahlen
            for(int i=0; i<Player.size();i++){
                Spieler spieler1=(Spieler) Player.get(i);
                spieler1.Einzahlung(mInterface1.einzahlung(i));
                Player.set(i,spieler1);
            }
        }
        //Wenn man kein Geld mehr hat fliegt man raus
        for(int i=0; i<Player.size();i++) {
            Spieler spieler1 = (Spieler) Player.get(i);
            if(spieler1.getKonto()<=0) {
                Player.remove(i);
            }
        }
    }
}
