package tollBarrier.vehicule;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestVehicule {

	Vehicule v;
	@Before
	public void setUp() throws Exception {
		Set<MoyenDePaiment> mdp = new HashSet<MoyenDePaiment>();
		mdp.add(MoyenDePaiment.CB);
		v = new Voiture(mdp);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTempsPassage() {
		//TODO v.rejoindreFile(new FileDAttente());
		int millis = 2000;
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		v.quitterPeage();
		
		assertTrue(v.getTempsPassage()==millis);
	}
}
