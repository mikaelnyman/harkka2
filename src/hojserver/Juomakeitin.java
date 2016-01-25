package hojserver;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Juomakeitin {
    /**
     * 
     */
    private Juomamestari varaaja=null;
    
    private int tayttoaste=0;
    
    private int tila=0;
    
    private final int MAXMAARA=2000;
    
    private boolean operaatio=false;

    /**
     * Yksikkö sekunti
     */
    private final int AIKA=20;

    /**
     * Luo uuden Juomakeitin-olion.
     */
    public Juomakeitin() {
    }

    /**
     * Palauttaa Juomamestari-olion, joka on juomakeittimen varaaja.
     * @return 
     */
    public Juomamestari getVaraaja() {
        return varaaja;
    }

    /**
     * Palauttaa juomakeittimen täyttöasteen.
     * @return juomakeittimen täyttöaste
     */
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

    /**
     * Asettaa parametrina saadun Juomamestari-olion juomakeittimen varaajaksi.
     * @param varaaja 
     */
    public void setVaraaja(Juomamestari varaaja) {
        this.varaaja = varaaja;
    }

    /**
     * Asettaa juomakeittimen täyttöasteeksi parametrina saadun lukuarvon.
     * @param tayttoaste 
     */
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

    /**
     * Palauttaa juomakeittimen maksimitilavuuden.
     * @return juomakeittimen maksimitilavuus
     */
    public int getMAXMAARA() {
        return MAXMAARA;
    } 

    public boolean isOperaatio() {
        return operaatio;
    }

    public void setOperaatio(boolean operaatio) {
        this.operaatio = operaatio;
    }
}