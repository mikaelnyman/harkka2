package hojclient;

import java.rmi.Naming;

/**
 *
 * @author Mikael
 */
public class Palvelin {
    public static void kaynnista(){
        try{
            Laitos viinatehdas=new Laitos(
                new Ruuvikuljetin(), 
                new Siilo[]{new Siilo(),new Siilo(),new Siilo(),new Siilo()}, 
                new Ruuvikuljetin[]{new Ruuvikuljetin(),new Ruuvikuljetin()},
                new Juomakeitin[]{new Juomakeitin(),new Juomakeitin(),new Juomakeitin()},
                new Pumppu[]{new Pumppu(), new Pumppu()},
                new Kypsytyssailio[]{new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio()},
                new Pumppu[]{new Pumppu(), new Pumppu()}
            );
            Naming.rebind("viinatehdas", viinatehdas);
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    } // kaynnista
} // class Palvelin
