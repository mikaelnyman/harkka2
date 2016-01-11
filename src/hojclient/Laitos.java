/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hojclient;

/**
 * Esittää koko laitosta ja sisältää kaikki osat
 * @author Mikael
 */
public class Laitos {
    /**
     * Siilon täyttö
     */
    private Ruuvikuljetin rk;
    
    /**
     * 4 kpl viljan säilytykseen
     */
    private Siilo[] siilot;
    
    /**
     * 2kpl siiloista keittimiin
     */
    private Ruuvikuljetin[] raakaAineKuljettimet;
    
    /**
     * 3 kpl juomakeittimiä
     */
    private Juomakeitin[] keittimet;
    
    /**
     * 2 kpl pumppuja keittimistä tankkeihin
     */
    private Pumppu[] pumput;
    
    /**
     * 10 kpl tankkeja
     */
    private Kypsytyssailio[] sailiot;
    
    /**
     * 2kpl pumppuja kypsystyssäiliöistä pullotukseen
     */
    private Pumppu[] pullotuspumput;
    
    public Laitos(Ruuvikuljetin r1, Siilo[] s, Ruuvikuljetin[] r2, Juomakeitin[] j, Pumppu[] p1, Kypsytyssailio[] k, Pumppu[] p2){
        rk=r1;
        siilot=s;
        raakaAineKuljettimet=r2;
        keittimet=j;
        pumput=p1;
        sailiot=k;
        pullotuspumput=p2;
    }
}
