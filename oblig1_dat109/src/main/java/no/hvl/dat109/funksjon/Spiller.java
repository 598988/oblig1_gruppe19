package no.hvl.dat109.funksjon;

public class Spiller {
	
	private String navn;
	private int verdi;

	public int getVerdi() {
		return verdi;
	}

	public void setVerdi(int verdi) {
		this.verdi = verdi;
	}

	public Spiller(String navn) {
		super();
		this.navn = navn;
		this.verdi=1;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	

}
