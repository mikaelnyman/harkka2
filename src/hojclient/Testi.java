/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojclient;

import hojserver.Palvelin;

/**
 * Käynnistää palvelimen ja asiakkaan käyttöliittymän.
 * @author Mikael, Josia, Lassi
 */
public class Testi {
    public static void main(String[] args){        
        Palvelin.kaynnista();
        MainWindow.main(null);
        MainWindow.main(null);
    }
}
