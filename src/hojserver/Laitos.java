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
        String[] str = new String[]{
            String.valueOf(rk.isPaalla()),
            String.valueOf(siilot[0].getTayttoaste()),
            String.valueOf(siilot[1].getTayttoaste()),
            String.valueOf(siilot[2].getTayttoaste()),
            String.valueOf(siilot[3].getTayttoaste()),
            siilot[0].getVaraaja()!=null?siilot[0].getVaraaja().toString():null,
            siilot[1].getVaraaja()!=null?siilot[1].getVaraaja().toString():null,
            siilot[2].getVaraaja()!=null?siilot[2].getVaraaja().toString():null,
            siilot[3].getVaraaja()!=null?siilot[3].getVaraaja().toString():null,
            String.valueOf(raakaAineKuljettimet[0].isPaalla()),
            String.valueOf(raakaAineKuljettimet[1].isPaalla()),
            keittimet[0].getVaraaja()!=null?keittimet[0].getVaraaja().toString():null,
            keittimet[1].getVaraaja()!=null?keittimet[1].getVaraaja().toString():null,
            keittimet[2].getVaraaja()!=null?keittimet[2].getVaraaja().toString():null,
            String.valueOf(keittimet[0].getTila()),
            String.valueOf(keittimet[1].getTila()),
            String.valueOf(keittimet[2].getTila()),
            String.valueOf(pumput[0].isPaalla()),
            String.valueOf(pumput[1].isPaalla()),
            String.valueOf(sailiot[0].getTayttoaste()),
            String.valueOf(sailiot[1].getTayttoaste()),
            String.valueOf(sailiot[2].getTayttoaste()),
            String.valueOf(sailiot[3].getTayttoaste()),
            String.valueOf(sailiot[4].getTayttoaste()),
            String.valueOf(sailiot[5].getTayttoaste()),
            String.valueOf(sailiot[6].getTayttoaste()),
            String.valueOf(sailiot[7].getTayttoaste()),
            String.valueOf(sailiot[8].getTayttoaste()),
            String.valueOf(sailiot[9].getTayttoaste()),
            String.valueOf(pullotuspumput[0].isPaalla()),
            String.valueOf(pullotuspumput[1].isPaalla()),
            sailiot[0].getVaraaja()!=null?sailiot[0].getVaraaja().toString():null,
            sailiot[1].getVaraaja()!=null?sailiot[1].getVaraaja().toString():null,
            sailiot[2].getVaraaja()!=null?sailiot[2].getVaraaja().toString():null,
            sailiot[3].getVaraaja()!=null?sailiot[3].getVaraaja().toString():null,
            sailiot[4].getVaraaja()!=null?sailiot[4].getVaraaja().toString():null,
            sailiot[5].getVaraaja()!=null?sailiot[5].getVaraaja().toString():null,
            sailiot[6].getVaraaja()!=null?sailiot[6].getVaraaja().toString():null,
            sailiot[7].getVaraaja()!=null?sailiot[7].getVaraaja().toString():null,
            sailiot[8].getVaraaja()!=null?sailiot[8].getVaraaja().toString():null,
            sailiot[9].getVaraaja()!=null?sailiot[9].getVaraaja().toString():null,
            String.valueOf(keittimet[0].getTayttoaste()),
            String.valueOf(keittimet[1].getTayttoaste()),
            String.valueOf(keittimet[2].getTayttoaste())
        };
        return str;
    }
    
    @Override
    public void taytaSiilot(Juomamestari jm) throws RemoteException
    {
        new Thread(){
            @Override
            public void run(){
                if(!rk.isPaalla()){
                    rk.setPaalla(true);
                    for(Siilo s:siilot){
                        if(s.getVaraaja()==null){
                            int x=s.getMAXMAARA()-s.getTayttoaste();  
                            if(x>0){
                                s.setOperaatio(true);
                                rk.kaynnista(s,x);
                                s.setOperaatio(false);
                            }
                        }
                    }
                    rk.setPaalla(false);
                }
            }
        }.start();
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
        new Thread(){
            int m=maara;
            public void run(){
                if(!raakaAineKuljettimet[a].isPaalla()){
                    raakaAineKuljettimet[a].setPaalla(true);
                    for(Siilo s:siilot){
                        if (!s.isOperaatio() && s.getVaraaja() != null && s.getVaraaja().equals(jm)){
                            s.setOperaatio(true);
                            for(Juomakeitin k:keittimet){
                                if(k.getVaraaja() != null && k.getVaraaja().equals(jm) && k.getTayttoaste()==0){
                                    int x = Math.min(Math.min(m, s.getTayttoaste()), k.getMAXMAARA());
                                    k.setOperaatio(true);
                                    raakaAineKuljettimet[a].kaynnistaSiilosta(s,k,x);
                                    k.setOperaatio(false);
                                    if (s.getTayttoaste()==0){
                                        s.setVaraaja(null);
                                    }
                                    m-=x;
                                    if(m==0){
                                        return;
                                    }
                                }
                            }
                            s.setVaraaja(null);
                            s.setOperaatio(false);
                        }
                    }
                    raakaAineKuljettimet[a].setPaalla(false);
                }    
            }
        }.start();
    }
    @Override
    public void pullota(int a,Juomamestari jm) throws RemoteException{
        new Thread(){
            @Override
            public void run(){
                if(!pullotuspumput[a].isPaalla()){
                    pullotuspumput[a].setPaalla(true);
                    for(Kypsytyssailio k:sailiot){
                        if(k.getVaraaja()!=null && k.getVaraaja().equals(jm) && !k.isOperaatio()){
                            k.setOperaatio(true);
                            pullotuspumput[a].pullota(k);
                            k.setVaraaja(null);
                            k.setOperaatio(false);
                        }
                    }
                    pullotuspumput[a].setPaalla(false);
                }
            }
        }.start();
    }
    
    @Override
    public void kypsyta(int a, Juomamestari jm) throws RemoteException{
        new Thread(){
            @Override
            public void run(){
                if(keittimet[a].getVaraaja()!=null && keittimet[a].getVaraaja().equals(jm) && keittimet[a].getTila()==0 && !keittimet[a].isOperaatio()){
                    keittimet[a].setOperaatio(true);
                    keittimet[a].keita();
                    keittimet[a].setOperaatio(false);
                }
            }
        }.start();
    }
    
    @Override
    public void pumppaa(int a, Juomamestari jm) throws RemoteException{
        new Thread(){
            @Override
            public void run(){
                if(!pumput[a].isPaalla()){
                    pumput[a].setPaalla(true);
                    for(Juomakeitin jk:keittimet){
                        if(jk.getVaraaja()!=null && jk.getVaraaja().equals(jm) && jk.getTila()==2){
                            for(Kypsytyssailio ks:sailiot){
                                if(ks.getVaraaja()!=null && ks.getVaraaja().equals(jm) && ks.getTayttoaste()==0 && !ks.isOperaatio()){
                                    int b=Math.min(jk.getTayttoaste(), ks.getMAXMAARA());
                                    ks.setOperaatio(true);
                                    pumput[a].pumppaa(b, jk, ks);
                                    ks.setOperaatio(false);
                                    if(jk.getTayttoaste()==0){
                                        jk.setVaraaja(null);
                                        jk.setTila(0);
                                    }
                                }
                            }
                        }
                    }
                    pumput[a].setPaalla(false);
                }
            }
        }.start();
    }
}