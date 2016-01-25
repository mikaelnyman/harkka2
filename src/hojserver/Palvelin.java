package hojserver;

import hojserver.Laitos;
import hojserver.Kypsytyssailio;
import hojserver.Juomakeitin;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author Mikael, Josia, Lassi
 */
public class Palvelin {
    /**
     * Käynnistää uuden palvelimen ja luo uuden Laitos-olion.
     * Luo myös laitoksen tarvitsemat muut luokat.
     */
    public static void kaynnista(){
        try{
            System.setProperty("java.security.policy","Laitos.policy");
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
            System.out.println("hojclient.Palvelin.kaynnista() suoritettu"); //testausta varten
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    } // kaynnista
} // class Palvelin
