/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojclient;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Taustasäije, joka päivittää asiakkaan käyttöliittymää.
 * @author Mikael, Josia, Lassi
 */
public class Paivittaja extends Thread{
    private final MainWindow nimi;
    public Paivittaja (MainWindow nimi){
        this.nimi = nimi;
    }
    /**
     * Huolehtii käyttöliittymän näkymän säännöllisestä päivittämisestä.
     */
    @Override
    public void run(){
        while(true){  
            nimi.paivitaKayttoliittyma();
            try {
                sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Paivittaja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
