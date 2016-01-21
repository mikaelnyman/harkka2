/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojserver;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mikael
 */
public class UnitTest {

    
 
    public static void main(String[] args) {
        try {
            Laitos tehdas = new Laitos(new Ruuvikuljetin(),
                    new Siilo[]{new Siilo(),new Siilo(),new Siilo(),new Siilo()},
                    new Ruuvikuljetin[]{new Ruuvikuljetin(),new Ruuvikuljetin()},
                    new Juomakeitin[]{new Juomakeitin(),new Juomakeitin(),new Juomakeitin()},
                    new Pumppu[]{new Pumppu(), new Pumppu()},
                    new Kypsytyssailio[]{new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio()},
                    new Pumppu[]{new Pumppu(), new Pumppu()}
            );
            System.out.println("Laitos luotu onnistuneesti");
            tehdas.testi();
        } catch (RemoteException ex) {
            System.err.println("tapahtui virhe");
            Logger.getLogger(UnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
