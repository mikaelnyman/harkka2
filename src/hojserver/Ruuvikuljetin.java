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

    public void kaynnista(Siilo s,int maara) {
        try {
            System.out.println("Täyttö alkaa");
            try {
                for(int i=0;i<maara/KULJETUSNOPEUS*1000;i+=100){
                    Thread.sleep(100);
                    s.setTayttoaste((int)Math.round(s.getTayttoaste()+KULJETUSNOPEUS*0.1));
                }
                System.out.println("Täyttö päättyy ja säiliössä on "+s.getTayttoaste());
            } catch (InterruptedException ex) {
                System.out.println("Täyttö keskeytyi epäonnistuneesti");
                Logger.getLogger(Ruuvikuljetin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(Ruuvikuljetin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPaalla(boolean paalla) {
        this.paalla = paalla;
    }
    
}
