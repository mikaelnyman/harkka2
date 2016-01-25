package hojserver;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Ruuvikuljetin {
    
    private boolean paalla=false;
    
    /**
     * Yksikkö kg/s
     */
    private final int KULJETUSNOPEUS=200;

    public Ruuvikuljetin() {
    }

    public boolean isPaalla() {
        return paalla;
    }

    public void kaynnista(Siilo s,int maara) {
        try {
            for(int i=0;i<maara/KULJETUSNOPEUS*1000;i+=100){
                Thread.sleep(100);
                s.setTayttoaste((int)Math.round(s.getTayttoaste()+KULJETUSNOPEUS*0.1));
            }
            System.out.println("Täyttö päättyy ja säiliössä on "+s.getTayttoaste());
        } catch (InterruptedException ex) {
            System.out.println("Täyttö keskeytyi epäonnistuneesti");
            Logger.getLogger(Ruuvikuljetin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPaalla(boolean paalla) {
        this.paalla = paalla;
    }

    void kaynnistaSiilosta(Siilo s, Juomakeitin k, int x) {
        try{
            int sm=s.getTayttoaste();
            int km=k.getTayttoaste();
            for(int i=0;i<x/KULJETUSNOPEUS*1000;i+=100){
                Thread.sleep(100);
                sm-=KULJETUSNOPEUS*0.1;
                km+=KULJETUSNOPEUS*0.1;
                s.setTayttoaste(sm);
                k.setTayttoaste(km);
            }
            Thread.sleep(500);
            k.setTayttoaste(km*10000/2000);  //Lisätään vesi
        }
        catch(InterruptedException ie){
            System.out.println(ie.getMessage());
        }
    }    
}
