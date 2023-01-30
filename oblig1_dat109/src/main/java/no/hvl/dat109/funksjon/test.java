package no.hvl.dat109.funksjon;

public class test {

	public static void main(String[] args) {
		Spillere  spillere= new Spillere();
		spillere.getSpillere().add(new Spiller("Dog"));
		spillere.getSpillere().add(new Spiller("Cat"));
		Startspill spill = new Startspill(spillere);
		
		spill.start();
		
	}

}
