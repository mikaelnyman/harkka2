package hojserver;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Juomakeitin {
    /**
     * Juomakeittimen varannut Juomamestari
     */
    private Juomamestari varaaja=null;
    
    /**
     * Juomakeittimen täyttöaste
     */
    private int tayttoaste=0;
    
    /**
     * Juomakeittimen tilat:
     * 0=kylmä
     * 1=kiehuu
     * 2=valmis
     */
    private int tila=0;
    
    /**
     * Juomakeittimeen mahtuvan viljan maksimimäärä
     */
    private final int MAXMAARA=2000;
    
    /**
     * Onko juomakeittimeen liityvä operaatio kesken
     */
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

    /**
    * Palauttaa Juomakeitin-olion tilan.
    * 0 = kylmä, 1 = kiehuu, 2 = valmis
    * @return Juomakeitin-olion tila
    */
    public int getTila() {
        return tila;
    }

    /**
     * Asettaa Juomakeitin-olion tilaksi parametrina saadun lukuarvon.
     * 0 = kylmä, 1 = kiehuu, 2 = valmis
     * @param tila 
     */
    public void setTila(int tila) {
        this.tila = tila;
    }
    
    /**
     * Keittää Juomakeitin-olion sisällön. Keittämistä simuloidaan odottamalla
     * siihen kuluva aika ja päivittämällä Juomakeitin-olion tilaa.
     */
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

    /**
     * Palauttaa tiedon siitä, onko Juomakeitin-oliossa meneillään
     * jokin operaatio.
     * True = operaatio on meneillään, false = operaatiota ei ole käynnissä
     * @return Tieto siitä, onko Juomakeitin-oliossa meneillään jokin operaatio
     */
    public boolean isOperaatio() {
        return operaatio;
    }

    /**
     * Asettaa Juomakeitin-olion operaatio -parametrin arvoksi metodin
     * parametrina saadun arvon.
     * @param operaatio 
     */
    public void setOperaatio(boolean operaatio) {
        this.operaatio = operaatio;
    }
}