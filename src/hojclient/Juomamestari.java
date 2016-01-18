package hojclient;

public class Juomamestari {
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
