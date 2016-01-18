package hojclient;


public class Kypsytyssailio {
     /**
     * 
     */
    private Juomamestari varaaja;
    
    private boolean operaatio=false;
    
    private int tayttoaste=0;
    
    private final int MAXMAARA=10000;
    
    public Kypsytyssailio(){
    
    }

    public void setVaraaja(Juomamestari varaaja) {
        this.varaaja = varaaja;
    }

    public void setTayttoaste(int tayttoaste) {
        this.tayttoaste = tayttoaste;
    }

    public Juomamestari getVaraaja() {
        return varaaja;
    }

    public int getTayttoaste() {
        return tayttoaste;
    }

    public boolean isOperaatio() {
        return operaatio;
    }

    public void setOperaatio(boolean operaatio) {
        this.operaatio = operaatio;
    }

    public int getMAXMAARA() {
        return MAXMAARA;
    }
    
}
