package hojserver;


public class Kypsytyssailio {
    
    /**
     * Kypsytyssäiliön varaaja
     */
    private Juomamestari varaaja=null;
    
    /**
     * Onko kypsytyssäiliöön kohdistuva operaatio käynnissä
     */
    private boolean operaatio=false;
    
    /**
     * Kypsytyssäiliön täyttöaste
     */
    private int tayttoaste=0;
    
    /**
     * Täyttöasteen maksimimäärä
     */
    private final int MAXMAARA=10000;
    
    /**
     * Luo uuden Kypsytyssäiliö-olion.
     */
    public Kypsytyssailio(){
    
    }

    /**
     * Asettaa parametrina saadun Juomamestari-olion kypsytyssäiliön varaajaksi.
     * @param varaaja 
     */
    public void setVaraaja(Juomamestari varaaja) {
        this.varaaja = varaaja;
    }

    /**
     * Asettaa kypsytyssäiliön täyttöasteen parametrina saadun lukuarvon mukaan.
     * @param tayttoaste 
     */
    public void setTayttoaste(int tayttoaste) {
        this.tayttoaste = tayttoaste;
    }

    /**
     * Palauttaa Juomamestari-olion, joka on varannut kypsytyssäiliön.
     * @return kypsytysäiliön varaaja
     */
    public Juomamestari getVaraaja() {
        return varaaja;
    }

    /**
     * Palauttaa kypsytyssäiliön täyttöasteen.
     * @return täyttöaste
     */
    public int getTayttoaste() {
        return tayttoaste;
    }

    /**
     * Palauttaa tiedon siitä, onko kypsytyssäiliö käytössä.
     * True = on käytössä, false = ei ole käytössä.
     * @return Boolean tyyppinen tieto siitä, onko kypsytyssäiliö käytössä.
     */
    public boolean isOperaatio() {
        return operaatio;
    }

    /**
     * Asettaa parametrina saadun tiedon mukaan parametriin operaatio tiedon siitä,
     * onko kypsytyssäiliö käytössä.
     * True = on käytössä, false = ei ole käytössä
     * @param operaatio 
     */
    public void setOperaatio(boolean operaatio) {
        this.operaatio = operaatio;
    }

    /**
     * Palauttaa kypsytyssäiliön maksimitilavuuden.
     * @return Kypsytyssäiliön maksimitilavuus
     */
    public int getMAXMAARA() {
        return MAXMAARA;
    }
    
}
