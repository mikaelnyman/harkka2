package hojclient;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JuomamestariImplementaatio extends UnicastRemoteObject implements Juomamestari {
	private String nimi;
	public JuomamestariImplementaatio(String n) throws RemoteException
	{
		nimi=n;
	}
	public void TaytaSiilot(Ruuvikuljetin r) throws RemoteException
	{
		
	}
	public void VaraaSiilo(Siilo s) throws RemoteException
	{
		
	}
	public void VaraaKypsytyssailio(Kypsytyssailio k) throws RemoteException
	{
		
	}
	public void TaytaKypsytyssailio(Pumppu p) throws RemoteException
	{
		
	}
	public void VaraaJuomakeitin(Juomakeitin j) throws RemoteException
	{
		
	}
	public void TaytaJuomakeitin(Ruuvikuljetin k) throws RemoteException
	{
		
	}
	public void Pullota(Pumppu p) throws RemoteException
	{
		
	}
}
