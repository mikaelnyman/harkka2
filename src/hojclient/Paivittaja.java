/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojclient;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josia Nyman
 */
public class Paivittaja extends Thread{
    private MainWindow nimi;
    public Paivittaja (MainWindow nimi){
        this.nimi = nimi;
    }
public void run(){
    while (true){  
        nimi.paivitaKayttoliittyma();
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Paivittaja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
}
