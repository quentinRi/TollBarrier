package tollBarrier.vehicule;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFabriqueDeVehicule {

	@Test
	public void testCreerVehicule() {
		FabriqueDeVehicule f = new FabriqueDeVehicule();

		assertTrue(f.creerVehicule("Camion") instanceof Camion); 
		assertTrue(f.creerVehicule("DeuxRoues") instanceof DeuxRoues); 
		assertTrue(f.creerVehicule("Voiture") instanceof Voiture);

		assertTrue(f.creerVehicule("E") == null); 
	}

}
