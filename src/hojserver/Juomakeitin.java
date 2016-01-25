package hojserver;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Juomakeitin {
    /**
     * 
     */
    private Juomamestari varaaja=null;
    
    private int tayttoaste=0;
    
//    private boolean paalla=false;    
//    private boolean keitetty=false;
    
    /**
     * 0=ei keitetty
     * 1=keittää
     * 2=keitetty
     */
    private int tila=0;
    
    private final int MAXMAARA=2000;

    /**
     * Yksikkö sekunti
     */
    private final int AIKA=20;

    public Juomakeitin() {
    }

    public Juomamestari getVaraaja() {
        return varaaja;
    }

    public int getTayttoaste() {
        return tayttoaste;
    }

    /*
    public boolean isPaalla() {
        return paalla;
    }

    public void setPaalla(boolean paalla) {
        this.paalla = paalla;
    }
*/    

    public void setVaraaja(Juomamestari varaaja) {
        this.varaaja = varaaja;
    }

    public void setTayttoaste(int tayttoaste) {
        this.tayttoaste = tayttoaste;
    }

/*    public boolean isKeitetty() {
        return keitetty;
    }

    public void setKeitetty(boolean keitetty) {
        this.keitetty = keitetty;
    }*/

    public int getTila() {
        return tila;
    }

    public void setTila(int tila) {
        this.tila = tila;
    }
    
    public void keita(){
        try {
            tila=1;
            Thread.sleep(AIKA*1000);
            tila=2;
        } catch (InterruptedException ex) {
            Logger.getLogger(Juomakeitin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getMAXMAARA() {
        return MAXMAARA;
    } 
}