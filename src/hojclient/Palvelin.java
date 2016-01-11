package hojclient;

import java.rmi.Naming;
public class Palvelin {
    public static void kaynnista(){
        Laitos viinatehdas=new Laitos(
            new Ruuvikuljetin(), 
            new Siilo[]{new Siilo(),new Siilo(),new Siilo(),new Siilo()}, 
            new Ruuvikuljetin[]{new Ruuvikuljetin(),new Ruuvikuljetin()},
            new Juomakeitin[]{new Juomakeitin(),new Juomakeitin(),new Juomakeitin()},
            new Pumppu[]{new Pumppu(), new Pumppu()},
            new Kypsytyssailio[]{new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio()},
            new Pumppu[]{new Pumppu(), new Pumppu()}
        );
        
        try{

        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    } // main
} // class Palvelin
