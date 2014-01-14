package tollBarrier.vehicule;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tollBarrier.vehicule.exceptions.NotGoneVehiculeException;
import tollBarrier.vehicule.vehiculesObjects.*;

public class TestVehicule {

	Vehicule v;
	Vehicule c;
	Vehicule d;
	Set<MoyenDePaiment> mdp;
	
	@Before
	public void setUp() throws Exception {
		mdp = new HashSet<MoyenDePaiment>();
		mdp.add(MoyenDePaiment.CB);
		v = new Voiture(mdp);
		c = new Camion(mdp);
		d = new DeuxRoues(mdp);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	
	//rejoindreFile() et quitterPeage() testés par effet de bord dans testGetTempsPassage()
	
	@Test
	public void testgetMoyensDePaiment() {
		assertTrue(v.getMoyensDePaiment().equals(mdp));
		assertTrue(c.getMoyensDePaiment().equals(mdp));
		assertTrue(d.getMoyensDePaiment().equals(mdp));
		
	}
	
	@Test
	public void testGetTempsPassage() throws InterruptedException {
		long pause = 1;
		
		try {
			v.rejoindreFile();
			c.rejoindreFile();
			d.rejoindreFile();
		
			Thread.sleep(pause*1000);
		
			v.quitterPeage();
			c.quitterPeage();

			assertTrue(v.getTime() == pause);
			assertTrue(c.getTime() == pause);
		}
		catch(NotGoneVehiculeException e) {
			assertTrue(false);
		}
		
		try { 
			d.getTime();
			assertTrue(false);
		}
		catch(NotGoneVehiculeException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testGetTimeMultiplier() {
		assertTrue(v.getTimeMuliplier() == 7);
		assertTrue(c.getTimeMuliplier() == 10);
		assertTrue(d.getTimeMuliplier() == 5);
	}
	
	@Test
	public void testToString() {
		String s = "Voiture n°0";
		assertTrue(s.equals(v.toString()));
		s = "Camion n°1";
		assertTrue(s.equals(c.toString()));
		s = "DeuxRoues n°2";
		assertTrue(s.equals(d.toString()));
	}
	
	@Test
	public void testGetMontantPaiment() {
		assertTrue(v.getMontantPaiment() <= 40 && v.getMontantPaiment() >= 5);
		assertTrue(d.getMontantPaiment() <= 40 && v.getMontantPaiment() >= 5);
		assertTrue(c.getMontantPaiment() <= 60 && v.getMontantPaiment() >= 10);
	}
}
