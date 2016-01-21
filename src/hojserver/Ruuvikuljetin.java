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

    public void kaynnista(int maara) {
//        this.paalla = true;
        try {
            Thread.sleep(maara/KULJETUSNOPEUS*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ruuvikuljetin.class.getName()).log(Level.SEVERE, null, ex);
        }
//        this.paalla=false;
    }

    public void setPaalla(boolean paalla) {
        this.paalla = paalla;
    }
    
}
