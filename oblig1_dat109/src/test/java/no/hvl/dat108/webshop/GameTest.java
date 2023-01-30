package no.hvl.dat108.webshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.intThat;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.funksjon.Spiller;
import no.hvl.dat109.funksjon.Spillere;
import no.hvl.dat109.funksjon.Startspill;
import no.hvl.dat109.loginUtil.InputValidator;


public class GameTest {


	
	Spillere spillere = new Spillere();
	Startspill spill= new Startspill(spillere);
	
	Spiller spiller1 = new Spiller("spiller 1");
	Spiller spiller2 = new Spiller("spiller 2");
	Spiller spiller3 = new Spiller("spiller 3");
	Spiller spiller4 = new Spiller("spiller 4");
	
    @Test
    public void twoPlayers() {
    	
    	spill.getSpillere().getSpillere().add(spiller1);
    	spill.getSpillere().getSpillere().add(spiller2);
    	
    	
        assertTrue(spill.getSpillere().getSpillere().contains(spiller1));
        assertTrue(spill.getSpillere().getSpillere().contains(spiller2));
        
        assertTrue(spill.getSpillere().getSpillere().size()==2);
       
    }
    
    @Test
    public void threePlayers() {
    	spillere.getSpillere().add(spiller1);
    	spillere.getSpillere().add(spiller2);
    	spillere.getSpillere().add(spiller3);
        
    	 assertTrue(spillere.getSpillere().contains(spiller1));
         assertTrue(spillere.getSpillere().contains(spiller2));
         assertTrue(spillere.getSpillere().contains(spiller3));
         
         assertTrue(spillere.getSpillere().size()==3);
    	
    }
    
    @Test
    public void fourPlayers() {
    	
    	spill.getSpillere().getSpillere().add(spiller1);
    	spill.getSpillere().getSpillere().add(spiller2);
    	spill.getSpillere().getSpillere().add(spiller3);
    	spill.getSpillere().getSpillere().add(spiller4);
        
    	 assertTrue(spill.getSpillere().getSpillere().contains(spiller1));
         assertTrue(spill.getSpillere().getSpillere().contains(spiller2));
         assertTrue(spill.getSpillere().getSpillere().contains(spiller3));
         assertTrue(spill.getSpillere().getSpillere().contains(spiller4));
         
         assertTrue(spill.getSpillere().getSpillere().size()==4);
    }
    
    @Test
    public void flytteSpiller() {
    
    	spiller1.setVerdi(50);
    	spill.getSpillere().getSpillere().add(spiller1);
    	int flyttTilRute = spill.flytt(spiller1.getVerdi());
    	spiller1.setVerdi(flyttTilRute);
    	
    	assertTrue(spiller1.getVerdi()==flyttTilRute);
     	
    	
    }
    
    
    @Test
    public void sjekketOmEnSpillerHarVunnet() {
    	spiller1.setVerdi(100);
    	spill.getSpillere().getSpillere().add(spiller1);
    	spill.getSpillere().getSpillere().add(spiller2);
    	spill.getSpillere().getSpillere().add(spiller3);
    	spill.getSpillere().getSpillere().add(spiller4);
    	
    	
    	assertTrue(spill.sjekkvunnet(spiller1.getVerdi()));
     	assertFalse(spill.sjekkvunnet(spiller2.getVerdi()));
    	assertFalse(spill.sjekkvunnet(spiller3.getVerdi()));
    	assertFalse(spill.sjekkvunnet(spiller4.getVerdi()));
    	
    }
    
    
    
    

}
