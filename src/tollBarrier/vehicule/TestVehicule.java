package tollBarrier.vehicule;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tollBarrier.vehicule.vehiculesObjects.Vehicule;
import tollBarrier.vehicule.vehiculesObjects.Voiture;

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
		
	}
}
