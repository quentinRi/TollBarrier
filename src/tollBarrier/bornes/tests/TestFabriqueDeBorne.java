package tollBarrier.bornes.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tollBarrier.bornes.BoAutomatique;
import tollBarrier.bornes.BoManuelle;
import tollBarrier.bornes.BoTelePeage;
import tollBarrier.bornes.FabriqueDeBorne;

public class TestFabriqueDeBorne {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	public void testCreerBorne(){
		
		FabriqueDeBorne f = new FabriqueDeBorne();
		
		assertTrue(f.creerBorne("Manuelle") instanceof BoManuelle);
		assertTrue(f.creerBorne("Telepeage") instanceof BoTelePeage);
		assertTrue(f.creerBorne("Automatique") instanceof BoAutomatique);
		assertTrue(f.creerBorne("x") == null);
	}

}
