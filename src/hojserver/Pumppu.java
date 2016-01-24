package hojserver;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Pumppu {
    
    private boolean paalla=false;
    /**
     * Yksikkö l/s
     */
    private final int KULJETUSNOPEUS=500;

    /**
     * Luo uuden Pumppu-olion.
     */
    public Pumppu() {
    }

    /**
     * palauttaa tiedon siitä, onko pumppu päällä.
     * True = päällä, false = pois päältä
     * @return Boolean arvo sen mukaan, onko pumppu päällä.
     */
    public boolean isPaalla() {
        return paalla;
    }

    /**
     * Asettaa pumppuun tiedon siitä, onko se päällä parametrina annetun boolean arvon mukaan.
     * True = päällä, false = pois päältä.
     * @param paalla 
     */
    public void setPaalla(boolean paalla) {
        this.paalla = paalla;
    }
    
    /**
     * Simuloi pumppaustapahtumaa. Parametrina annetaan pumpattava määrä.
     * Pumppaustapahtumaa simuloidaan odottamalla pumppaukseen kuluva aika.
     * @param maara 
     */
    public void pumppaa(int maara){
        try {
            Thread.sleep(maara/KULJETUSNOPEUS*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pumppu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}