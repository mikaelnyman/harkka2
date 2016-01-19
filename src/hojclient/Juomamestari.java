package hojclient;

import java.io.Serializable;

public class Juomamestari implements Serializable{
	private String nimi;
	public Juomamestari(String n)
	{
		nimi=n;
                System.out.println("Luotu juomamestari nimeltä "+nimi);
	}
        
        public String toString(){
            return nimi;
        }
        
        public boolean equals(Juomamestari jm){
            return nimi.equals(jm.toString());
        }
}
