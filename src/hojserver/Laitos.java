/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hojserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Esittää koko laitosta ja sisältää kaikki osat
 * @author Mikael
 */
public class Laitos extends UnicastRemoteObject implements LaitosRajapinta{
    /**
     * Siilon täyttö
     */
    private final Ruuvikuljetin rk;
    
    /**
     * 4 kpl viljan säilytykseen
     */
    private final Siilo[] siilot;
    
    /**
     * 2kpl siiloista keittimiin
     */
    private final Ruuvikuljetin[] raakaAineKuljettimet;
    
    /**
     * 3 kpl juomakeittimiä
     */
    private final Juomakeitin[] keittimet;
    
    /**
     * 2 kpl pumppuja keittimistä tankkeihin
     */
    private final Pumppu[] pumput;
    
    /**
     * 10 kpl tankkeja
     */
    private final Kypsytyssailio[] sailiot;
    
    /**
     * 2kpl pumppuja kypsystyssäiliöistä pullotukseen
     */
    private final Pumppu[] pullotuspumput;
    
    public Laitos(Ruuvikuljetin r1, Siilo[] s, Ruuvikuljetin[] r2, Juomakeitin[] j, Pumppu[] p1, Kypsytyssailio[] k, Pumppu[] p2) throws RemoteException{
        super();
        rk=r1;
        siilot=s;
        raakaAineKuljettimet=r2;
        keittimet=j;
        pumput=p1;
        sailiot=k;
        pullotuspumput=p2;
    }
    /**
     * Tänne tulee koko logiikka.
     * Kaikki metodit pitää esitellä myös LaitosRajapinnassa.
     * @return laitoksen tila
     * @throws java.rmi.RemoteException
     */
    @Override
    public String[] annaTiedot() throws RemoteException{
        System.out.println("annaTiedot()");
        String[] str = new String[]{String.valueOf(rk.isPaalla()),String.valueOf(siilot[0].getTayttoaste()),String.valueOf(siilot[1].getTayttoaste()),
             String.valueOf(siilot[2].getTayttoaste()),String.valueOf(siilot[3].getTayttoaste()),siilot[0].getVaraaja().toString(),siilot[1].getVaraaja().toString(),
             siilot[2].getVaraaja().toString(),siilot[3].getVaraaja().toString(),String.valueOf(raakaAineKuljettimet[0].isPaalla()),
             String.valueOf(raakaAineKuljettimet[1].isPaalla()),keittimet[0].getVaraaja().toString(),keittimet[1].getVaraaja().toString(),
             keittimet[2].getVaraaja().toString(),String.valueOf(keittimet[0].isPaalla()),String.valueOf(keittimet[1].isPaalla()),
             String.valueOf(keittimet[2].isPaalla()),String.valueOf(pumput[0].isPaalla()),String.valueOf(pumput[1].isPaalla()),
             String.valueOf(sailiot[0].getTayttoaste()),String.valueOf(sailiot[1].getTayttoaste()),String.valueOf(sailiot[2].getTayttoaste()),
             String.valueOf(sailiot[3].getTayttoaste()),String.valueOf(sailiot[4].getTayttoaste()),String.valueOf(sailiot[5].getTayttoaste()),
             String.valueOf(sailiot[6].getTayttoaste()),String.valueOf(sailiot[7].getTayttoaste()),String.valueOf(sailiot[8].getTayttoaste()),
             String.valueOf(sailiot[9].getTayttoaste()),String.valueOf(pullotuspumput[0].isPaalla()),String.valueOf(pullotuspumput[1].isPaalla())};
         System.out.println(str.length);
         return str;
    }
    
    @Override
    public void taytaSiilot(Juomamestari jm) throws RemoteException
    {
        
        for(Siilo s:siilot){
            if(s.getVaraaja()==null){
                s.setVaraaja(jm);
            }
        }
        for(Siilo s:siilot){
            if(s.getVaraaja().equals(jm) && !s.isOperaatio()){
                s.setOperaatio(true);
                int x=s.getMAXMAARA()-s.getTayttoaste();
                rk.setPaalla(true);
                rk.kaynnista(x);
                rk.setPaalla(false);
                s.setTayttoaste(s.getMAXMAARA());
                s.setVaraaja(null);
                s.setOperaatio(false);
            }
        }
    }
    @Override
    public void varaaSiilo(int a, Juomamestari jm) throws RemoteException
    {
        if(siilot[a].getVaraaja()==null){
            siilot[a].setVaraaja(jm);
        }
    }

    @Override
    public void varaaKypsytyssailio(int a, Juomamestari jm) throws RemoteException
    {
        if(sailiot[a].getVaraaja()==null){
            sailiot[a].setVaraaja(jm);
        }
    }

    @Override
    public void varaaJuomakeitin(int a, Juomamestari jm) throws RemoteException
    {
        if(keittimet[a].getVaraaja()==null){
            keittimet[a].setVaraaja(jm);
        }
    }
    @Override
    public void taytaJuomakeitin(int a, Juomamestari jm, int maara) throws RemoteException
    {
        if(!raakaAineKuljettimet[a].isPaalla()){
            raakaAineKuljettimet[a].setPaalla(true);
            for(Siilo s:siilot){
                if (!s.isOperaatio() && s.getVaraaja() != null && s.getVaraaja().equals(jm)){
                    s.setOperaatio(true);
                    for(Juomakeitin k:keittimet){
                        if(k.getVaraaja() != null && k.getVaraaja().equals(jm) && k.getTayttoaste()==0){
                            int x = Math.min(Math.min(maara, s.getTayttoaste()), k.getMAXMAARA());
                            raakaAineKuljettimet[a].kaynnista(x);
                            s.setTayttoaste(s.getTayttoaste()-x);
                            k.setTayttoaste(x);
                            if (s.getTayttoaste()==0){
                                s.setVaraaja(null);
                            }
                        }
                    }
                }
            }
            raakaAineKuljettimet[a].setPaalla(false);
        }    
    }
    @Override
    public void pullota(int a,Juomamestari jm) throws RemoteException
    {
        if(!pullotuspumput[a].isPaalla()){
            pullotuspumput[a].setPaalla(true);
            for(Kypsytyssailio k:sailiot){
                if(k!=null && k.getVaraaja().equals(jm) && !k.isOperaatio()){
                    k.setOperaatio(true);
                    pullotuspumput[a].pumppaa(k.getTayttoaste());
                    k.setTayttoaste(0);
                    k.setVaraaja(null);
                    k.setOperaatio(false);
                }
            }
            pullotuspumput[a].setPaalla(false);
        }
    }
    
    @Override
    public void kypsyta(int a, Juomamestari jm) throws RemoteException{
        if(keittimet[a].getVaraaja()!=null && keittimet[a].getVaraaja().equals(jm) && !keittimet[a].isKeitetty()){
            keittimet[a].keita();
        }
    }
    
    @Override
    public void pumppaa(int a, Juomamestari jm) throws RemoteException{
        if(!pumput[a].isPaalla()){
            pumput[a].setPaalla(true);
            for(Juomakeitin jk:keittimet){
                if(jk.getVaraaja()!=null && jk.getVaraaja().equals(jm) && jk.isKeitetty()){
                    for(Kypsytyssailio ks:sailiot){
                        if(ks.getVaraaja()!=null && ks.getVaraaja().equals(jm) && ks.getTayttoaste()==0){
                            int b=Math.min(jk.getTayttoaste(), ks.getMAXMAARA());
                            pumput[a].pumppaa(b);
                            jk.setTayttoaste(jk.getTayttoaste()-b);
                            if(jk.getTayttoaste()==0){
                                jk.setVaraaja(null);
                            }
                        }
                    }
                }
            }
            pumput[a].setPaalla(false);
        }
    }
    /**
     * Kun toimii, voi poistaa
     * @return 
     */
    @Override
    public String[] testi(){
        System.out.println(rk.isPaalla());
        String[] s=new String[2];
        s[0]=null;
        /**
        System.out.println(rk.isPaalla()+String.valueOf(siilot[0].getTayttoaste())+String.valueOf(siilot[1].getTayttoaste())+
             String.valueOf(siilot[2].getTayttoaste())+String.valueOf(siilot[3].getTayttoaste())+siilot[0].getVaraaja().toString()+siilot[1].getVaraaja().toString()+
             siilot[2].getVaraaja().toString()+siilot[3].getVaraaja().toString()+String.valueOf(raakaAineKuljettimet[0].isPaalla())+
            String.valueOf(raakaAineKuljettimet[1].isPaalla())+keittimet[0].getVaraaja().toString()+keittimet[1].getVaraaja().toString() +
             keittimet[2].getVaraaja().toString()+String.valueOf(keittimet[0].isPaalla())+String.valueOf(keittimet[1].isPaalla()) +
             String.valueOf(keittimet[2].isPaalla())+String.valueOf(pumput[0].isPaalla())+String.valueOf(pumput[1].isPaalla())+
             String.valueOf(sailiot[0].getTayttoaste())+String.valueOf(sailiot[1].getTayttoaste())+String.valueOf(sailiot[2].getTayttoaste()) +
             String.valueOf(sailiot[3].getTayttoaste())+String.valueOf(sailiot[4].getTayttoaste())+String.valueOf(sailiot[5].getTayttoaste()) +
             String.valueOf(sailiot[6].getTayttoaste())+String.valueOf(sailiot[7].getTayttoaste())+String.valueOf(sailiot[8].getTayttoaste()) +
             String.valueOf(sailiot[9].getTayttoaste())+String.valueOf(pullotuspumput[0].isPaalla())+String.valueOf(pullotuspumput[1].isPaalla()));
             */
        return s;
    }
}
