package hojserver;

public class Siilo {
    
     /**
     * 
     */
    private Juomamestari varaaja=null;
    
    private int tayttoaste=0;
    
    private final int MAXMAARA=10000;
    
    private boolean operaatio=false;

    /**
     * Luo uuden Siilo-olion.
     */
    public Siilo() {
    }

    /**
     * Asettaa parametrina saadun Juomamestari-olion siilon varaajaksi.
     * @param varaaja 
     */
    public void setVaraaja(Juomamestari varaaja) {
        this.varaaja = varaaja;
    }

    /**
     * Asettaa siilon täyttöasteen parametrina saadun lukuarvon mukaan.
     * @param tayttoaste 
     */
    public void setTayttoaste(int tayttoaste) {
        this.tayttoaste = tayttoaste;
    }

    /**
     * Palauttaa siilon varaajana olevan Juomamestari-olion.
     * @return Juomamestari-olio, joka on varannut siilon.
     */
    public Juomamestari getVaraaja() {
        return varaaja;
    }

    /**
     * palauttaa tiedon siitä, kuinka täynnä siilo on.
     * @return Siilon täyttöaste
     */
    public int getTayttoaste() {
        return tayttoaste;
    }

    /**
     * Palauttaa tiedon siitä, mikä on siilon maksimitilavuus
     * @return Siilon maksimitilavuus
     */
    public int getMAXMAARA() {
        return MAXMAARA;
    }

    /**
     * Palauttaa tiedon siitä, onko siilo käytössä vai ei.
     * True = siilo on käytössä, false = siilo ei ole käytössä.
     * @return Boolean arvo sen mukaan, onko siilo käytössä.
     */
    public boolean isOperaatio() {
        return operaatio;
    }

    /**
     * Asettaa booleanin operaatio arvoksi parametrina saadun boolean arvon.
     * True = siilo on käytössä, false = siilo ei ole käytössä.
     * @param operaatio 
     */
    public void setOperaatio(boolean operaatio) {
        this.operaatio = operaatio;
    }
}
