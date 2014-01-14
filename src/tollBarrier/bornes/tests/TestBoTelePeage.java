package tollBarrier.bornes.tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tollBarrier.bornes.BoTelePeage;
import tollBarrier.vehicule.MoyenDePaiment;

public class TestBoTelePeage {

	BoTelePeage b;
	
	@Before
	public void setUp() throws Exception {
		b = new BoTelePeage();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	public void testgetMoyenDePaiement(){
		
		Set<MoyenDePaiment> s = b.getMoyensDePaiment();
		assertTrue(s instanceof Set<?>);
		assertTrue(s.contains(MoyenDePaiment.TELEPEAGE));
		
	}
	
	public void testtoString(){
		assertTrue(b.toString() instanceof String);
	}
}
