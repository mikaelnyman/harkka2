package hojserver;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Juomakeitin {
    /**
     * 
     */
    private Juomamestari varaaja=null;
    
    private int tayttoaste=0;
    
    private boolean paalla=false;
    
    private boolean keitetty=false;
    
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

    public boolean isPaalla() {
        return paalla;
    }

    public void setPaalla(boolean paalla) {
        this.paalla = paalla;
    }
    

    public void setVaraaja(Juomamestari varaaja) {
        this.varaaja = varaaja;
    }

    public void setTayttoaste(int tayttoaste) {
        this.tayttoaste = tayttoaste;
    }

    public boolean isKeitetty() {
        return keitetty;
    }

    public void setKeitetty(boolean keitetty) {
        this.keitetty = keitetty;
    }
    
    public void keita(){
        try {
            Thread.sleep(AIKA*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Juomakeitin.class.getName()).log(Level.SEVERE, null, ex);
        }
        keitetty=true;
    }

    public int getMAXMAARA() {
        return MAXMAARA;
    }
    
    
}
