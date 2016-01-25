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
    public void pumppaa(int maara, Juomakeitin jk, Kypsytyssailio ks){
        try {
            int jkm=jk.getTayttoaste();
            int ksm=0;
            for(int i=0;i<maara/KULJETUSNOPEUS*1000;i+=100){
                Thread.sleep(100);
                jkm-=KULJETUSNOPEUS*0.1;
                ksm+=KULJETUSNOPEUS*0.1;
                jk.setTayttoaste(jkm);
                ks.setTayttoaste(ksm);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Pumppu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Pumppaa kypsytyssäiliön sisällön pullotukseen. Parametrina annetaan
     * kypsytyssäiliö, jonka sisältö pumpataan. Pumppaustapahtumaa simuloidaan odottamalla
     * siihen kuluva aika ja päivittämällä kypsytyssäiliössä olevan nesteen määrää.
     * @param k 
     */
    void pullota(Kypsytyssailio k) {
        try{
            int km=k.getTayttoaste();
            int stop=km/KULJETUSNOPEUS*1000;
            for(int i=0;i<stop;i+=100){
                Thread.sleep(100);
                km-=KULJETUSNOPEUS/10;
                k.setTayttoaste(km);
            }
        }
        catch(InterruptedException ie){
            System.out.println(ie.getMessage());
        }
    }
}