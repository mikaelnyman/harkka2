package hojclient;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Pumppu {
    
    private boolean paalla=false;
    /**
     * Yksikkö l/s
     */
    private final int KULJETUSNOPEUS=500;

    public Pumppu() {
    }

    public boolean isPaalla() {
        return paalla;
    }

    public void setPaalla(boolean paalla) {
        this.paalla = paalla;
    }
    
    public void pumppaa(int maara){
        try {
            Thread.sleep(maara/KULJETUSNOPEUS*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pumppu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}