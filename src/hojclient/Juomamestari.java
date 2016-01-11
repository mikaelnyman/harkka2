package hojclient;
import java.rmi.Remote;
import java.rmi.RemoteException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mikael
 */
public interface Juomamestari extends Remote{
	public void TaytaSiilot(Ruuvikuljetin r) throws RemoteException;
	public void VaraaSiilo(Siilo s) throws RemoteException;
	public void VaraaKypsytyssailio(Kypsytyssailio k) throws RemoteException;
	public void TaytaKypsytyssailio(Pumppu p) throws RemoteException;
	public void VaraaJuomakeitin(Juomakeitin j) throws RemoteException;
	public void TaytaJuomakeitin(Ruuvikuljetin k) throws RemoteException;
	public void Pullota(Pumppu p) throws RemoteException;
}
