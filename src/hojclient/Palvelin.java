package hojclient;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
/**
 *
 * @author Mikael
 */
public class Palvelin {
    public static void kaynnista(){
        try{
            System.setProperty("java.security.policy","server.policy");
            Laitos viinatehdas=new Laitos(
                new Ruuvikuljetin(), 
                new Siilo[]{new Siilo(),new Siilo(),new Siilo(),new Siilo()}, 
                new Ruuvikuljetin[]{new Ruuvikuljetin(),new Ruuvikuljetin()},
                new Juomakeitin[]{new Juomakeitin(),new Juomakeitin(),new Juomakeitin()},
                new Pumppu[]{new Pumppu(), new Pumppu()},
                new Kypsytyssailio[]{new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio(),new Kypsytyssailio()},
                new Pumppu[]{new Pumppu(), new Pumppu()}
            );
            Registry registry = LocateRegistry.createRegistry(2016);
            Naming.rebind("//localhost:2016/Laitos", viinatehdas);
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    } // kaynnista
} // class Palvelin
