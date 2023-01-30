package no.hvl.dat109.funksjon;

import java.util.Random;

public class Startspill {
	
	private int brett = 100;
	private Spillere spillere;
	
	
	
	public Startspill(Spillere spillere) {
		super();
		this.spillere = spillere;
	}
	public int getBrett() {
		return brett;
	}

	public Spillere getSpillere() {
		return spillere;
	}
	public void setSpillere(Spillere spillere) {
		this.spillere = spillere;
	}
	
	public int trill() {
		//int terning = 7; 
		//Random rand = new Random();
		return (int)(Math.random()*6+1);
		//return rand.nextInt(terning); //terningen kan vises entan mellom 0 til 6
	}
	
	public int flytt(int sum) {
		int flytt = sum+trill();
		
		if(flytt >100) {
			return sum;
		}
		
		return flytt;
	}
	
	public boolean sjekkvunnet(int sum) {
		
		return sum==100;
		
	}

	/*
	public void spilltrekk() {
		for(Spiller spiller: spillere.getSpillere()) {
			//int verdi = trill();
			//spiller.setVerdi(spiller.getVerdi());
			//int flyttVerdi = spiller.getVerdi();
			int flytt = flytt(spiller.getVerdi());
			spiller.setVerdi(flytt);
			System.out.println(spiller.getNavn() + " " + spiller.getVerdi());
			sjekkvunnet(spiller.getVerdi());
		}
	}
	*/
	
	public String spilltrekk() {
		for(Spiller spiller: spillere.getSpillere()) {
			//int verdi = trill();
			//spiller.setVerdi(spiller.getVerdi());
			//int flyttVerdi = spiller.getVerdi();
			int flytt = flytt(spiller.getVerdi());
			spiller.setVerdi(flytt);
			System.out.println(spiller.getNavn() + " " + spiller.getVerdi());
			sjekkvunnet(spiller.getVerdi());
		}
		return "Runde";
	}
	
	
	
	public void start() {
		
		//loop for runder 
		for(int i= 0; i<=10;i++) {
			
			//enda lopp inni runder, der vi gjøre trill, flytt, test på vunnet, spilltrekk
			for(Spiller spiller: spillere.getSpillere()) {
				//int verdi = trill();
				//spiller.setVerdi(spiller.getVerdi());
				//int flyttVerdi = spiller.getVerdi();
				int flytt = flytt(spiller.getVerdi());
				spiller.setVerdi(flytt);
				System.out.println(spiller.getNavn() + " " + spiller.getVerdi());
				sjekkvunnet(spiller.getVerdi());
			}
		}
		
	}

}
