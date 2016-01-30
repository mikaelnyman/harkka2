package hojserver;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Ruuvikuljetin {
    
    /**
     * Tieto siitä, onko ruuvikuljetin päällä
     */
    private boolean paalla=false;
    
    /**
     * Yksikkö kg/s
     */
    private final int KULJETUSNOPEUS=200;

    /**
     * Luo uuden Ruuvikuljetin-olion.
     */
    public Ruuvikuljetin() {
    }

    /**
     * Palauttaa tiedon siitä, onko ruuvikuljetin päällä.
     * True = päällä, false = pois päältä
     * @return Boolean tyyppinen arvo siitä, onko ruuvikuljetin päällä.
     */
    public boolean isPaalla() {
        return paalla;
    }

    /**
     * Täyttää parametrina s saatuun siiloon parametrina maara saadun määrän raaka-ainetta.
     * Täyttöä simuloidaan odottamalla siihen kuluva aika ja päivittämällä siilon täyttöastetta.
     * @param s
     * @param maara 
     */
    public void kaynnista(Siilo s,int maara) {
        try {
            for(int i=0;i<maara/KULJETUSNOPEUS*1000;i+=100){
                Thread.sleep(100);
                s.setTayttoaste((int)Math.round(s.getTayttoaste()+KULJETUSNOPEUS*0.1));
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Ruuvikuljetin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Asettaa parametriin paalla tiedon siitä, onko ruuvikuljetin päällä.
     * Tieto asetetaan parametrina saadun boolean tyyppisen arvon perusteella.
     * True = päällä, false = pois päältä
     * @param paalla 
     */
    public void setPaalla(boolean paalla) {
        this.paalla = paalla;
    }

    /**
     * Kuljettaa raaka-ainetta parametrina s saadusta siilosta parametrina k saatuun
     * juomakeittimeen. Kuljetettavan raaka-aineen määrä saadaan parametrina x.
     * Kuljetustapahtumaa simuloidaan odottamalla kuljetukseen kuluva aika ja päivittämällä
     * siilon ja juomakeittimen täyttöasteita.
     * @param s
     * @param k
     * @param x 
     */
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
