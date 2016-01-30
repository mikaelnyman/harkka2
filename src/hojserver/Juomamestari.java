package hojserver;

import java.io.Serializable;

public class Juomamestari implements Serializable{
    private String nimi;

    /**
     * Luo uuden Juomamestari-olion, jonka nimeksi asetetaan parametrina saatu
     * merkkijono. Metodi myös tulostaa tiedon siitä, että uusi Juomamestari-olio on luotu.
     * @param n 
     */
    public Juomamestari(String n)
    {
            nimi=n;
    }

    /**
     * Palauttaa Juomamestari-olion nimen merkkijonona
     * @return Juomamestari-olion nimi merkkijonona
     */
    @Override
    public String toString(){
        return nimi;
    }

    /**
     * Palauttaa boolean tyyppisen tiedon siitä, onko parametrina saadun
     * Juomamestari-olion nimi sama kuin kyseisen Juomamestari-olion nimi.
     * @param jm
     * @return Boolean tyypppinen arvo siitä, onko tämän Juomamestari-olion nimi
     * sama kuin parametrina saadun Juomamestari-olion nimi
     */
    public boolean equals(Juomamestari jm){
        return nimi.equals(jm.toString());
    }
}
