/*package tollBarrier.vehicule;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tollBarrier.bornes.BoAutomatique;
import tollBarrier.bornes.BoManuelle;
import tollBarrier.bornes.BoTelePeage;

public class TestFileDAttente {

	FileDAttente f;
	
	@Before
	public void setUp() throws Exception {
		f = new FileDAttente();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAjouterVehicule() {

		FabriqueDeVehicule fab = new FabriqueDeVehicule();
		Set<MoyenDePaiment> mdp = new HashSet<MoyenDePaiment>();
		mdp.add(MoyenDePaiment.Liquide);
		mdp.add(MoyenDePaiment.CB);
		
		Vehicule v1 = fab.creerVehicule("Voiture", mdp); 
		f.ajouterVehicule(v1);
		
		Vehicule v2 = fab.creerVehicule("Camion", mdp);
		f.ajouterVehicule(v2);
		
		mdp.remove(MoyenDePaiment.CB);
		Vehicule v3 = fab.creerVehicule("DeuxRoues", mdp);
		f.ajouterVehicule(v3);
		
//		assertTrue(f.file.contains(v1));
//		assertTrue(f.file.contains(v2));
//		assertTrue(f.file.contains(v3));
//		Pas testable, privé !
		
		
	}

	@Test
	public void testRecupererVehicule() {
		
		FabriqueDeVehicule fab = new FabriqueDeVehicule();
		Set<MoyenDePaiment> mdp = new HashSet<MoyenDePaiment>();
		mdp.add(MoyenDePaiment.Liquide);
		mdp.add(MoyenDePaiment.CB);
		
		Vehicule v1 = fab.creerVehicule("Voiture", mdp); 
		f.ajouterVehicule(v1);
		
		Vehicule v2 = fab.creerVehicule("Camion", mdp);
		f.ajouterVehicule(v2);
		
		mdp.remove(MoyenDePaiment.CB);
		Vehicule v3 = fab.creerVehicule("DeuxRoues", mdp);
		f.ajouterVehicule(v3);
		
		
		Vehicule r = null;
		try {
			r = f.recupererVehicule(new BoManuelle());
		} catch (PasDeVehiculeTrouveException e) {
			fail("Vehicule non trouvé");
		}
		assertTrue(r.equals(v1));
		//assertTrue(! f.file.contains(v1));
		
		Vehicule r2 = null;
		try {
			r2 = f.recupererVehicule(new BoAutomatique());
		} catch (PasDeVehiculeTrouveException e) {
			fail("Vehicule non trouvé");
		}

		assertTrue((r2.equals(v2) || r2.equals(v3)) && !r2.equals(r));
		//assertTrue(! f.file.contains(r2));
		
		
		Vehicule r3 = null;
		try {
			r3 = f.recupererVehicule(new BoTelePeage());
		} catch (PasDeVehiculeTrouveException e) {
			fail("Vehicule non trouvé");
		}

		assertTrue(((r3.equals(v2) || r3.equals(v3))) && !r2.equals(r3) && !r3.equals(r));
		//assertTrue(! f.file.contains(r3));
		
		Vehicule r4 = null;
		try {
			r4 = f.recupererVehicule(new BoAutomatique());
		} catch (PasDeVehiculeTrouveException e) {
			assertTrue(true);
		}
		if(r4 != null)
			fail("Aucun véhicule n'aurait dû être trouvé !");
	}

}
*/