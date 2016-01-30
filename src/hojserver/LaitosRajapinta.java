/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI-tekniikkaa varten luotu Laitos-olion rajapinta.
 * @author Mikael, Josia, Lassi
 */
public interface LaitosRajapinta extends Remote{
    public boolean kirjaudu(Juomamestari jm) throws RemoteException;
    public String[] annaTiedot() throws RemoteException;
    public void taytaSiilot(Juomamestari jm) throws RemoteException;
    public void varaaSiilo(int a, Juomamestari jm) throws RemoteException;
    public void varaaKypsytyssailio(int a, Juomamestari jm) throws RemoteException;
    public void pumppaa(int a, Juomamestari jm) throws RemoteException;
    public void varaaJuomakeitin(int a, Juomamestari jm) throws RemoteException;
    public void taytaJuomakeitin(int a, Juomamestari jm, int maara) throws RemoteException;
    public void pullota(int a, Juomamestari jm) throws RemoteException;
    public void kypsyta(int a, Juomamestari jm) throws RemoteException;
}
