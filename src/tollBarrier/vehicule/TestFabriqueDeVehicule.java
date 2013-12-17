package tollBarrier.vehicule;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFabriqueDeVehicule {

	FabriqueDeVehicule f;
	HashSet<MoyenDePaiment> s1;

	@Before
	public void setUp() {
		f = FabriqueDeVehicule.getInstance();

		s1 = new HashSet<MoyenDePaiment>();
		s1.add(MoyenDePaiment.ABONNEMENT);
		s1.add(MoyenDePaiment.CB);
		s1.add(MoyenDePaiment.LIQUIDE);
	}

	@After
	public void tearDown() {
	}
   
	@Test
	public void testCreerVehicule() {


		
		Vehicule v1 = f.creerVehicule("Camion", s1);
		Vehicule v2 = f.creerVehicule("DeuxRoues", s1);
		Vehicule v3 = f.creerVehicule("Voiture", s1);

		assertTrue(v1 instanceof Camion); 
		assertTrue(v2 instanceof DeuxRoues); 
		assertTrue(v3 instanceof Voiture);

		assertTrue(v1.getMoyensDePaiment().equals(s1));
		assertTrue(v2.getMoyensDePaiment().equals(s1));
		assertTrue(v3.getMoyensDePaiment().equals(s1));
		
		assertTrue(f.creerVehicule("E", s1) == null); 
	}

}
