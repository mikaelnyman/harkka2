package hojserver;

import hojserver.Juomamestari;


public class Siilo {
    
     /**
     * 
     */
    private Juomamestari varaaja=null;
    
    private int tayttoaste=0;
    
    private final int MAXMAARA=10000;
    
    private boolean operaatio=false;

    public Siilo() {
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
