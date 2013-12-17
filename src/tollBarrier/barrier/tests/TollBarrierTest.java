package tollBarrier.barrier.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tollBarrier.barrier.TollBarrier;
import tollBarrier.bornes.exceptions.NotAValidBorneTypeException;

public class TollBarrierTest
{
	TollBarrier	tb;

	@Before
	public void setUp() throws Exception
	{
		tb = new TollBarrier();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testaddDebit()
	{

	}

	/*@Test
	public void testTempsPassageMoyen()
	{
		assertTrue(tb.getTempsPassageMoyen() instanceof Float);
		assertTrue(tb.getNombreBornes() >= 0);
		int nbBornes = tb.getNombreBornes();
		float tempsPassageMoyen = 0;
		for (int i = 0; i < nbBornes; i++)
		{
			tempsPassageMoyen += tb.getTempsPassageMoyenParBorne(i);
		}
		tempsPassageMoyen /= nbBornes;
		assertTrue(tempsPassageMoyen == tb.getTempsPassageMoyen());

	}*/

	/*@Test
	public void testTempsPassageMoyenParBorne()
	{
		assertTrue(tb.getTempsPassageMoyenParBorne(0) instanceof Float);
		int nbBornes = tb.getNombreBornes();
		for (int i = 0; i < nbBornes; i++)
		{
			assertTrue(tb.getTempsPassageMoyenParBorne(i) >= 0);
		}
	}*/

	@Test
	public void testNombreVehiculeEnAttente()
	{
		assertTrue(tb.getNombreVehiculeEnAttente() instanceof Integer);
		assertTrue(tb.getNombreVehiculeEnAttente() >= 0);
	}

	@Test
	public void testaddIntervenant()
	{
		int nb = tb.getNombreIntervenants();
		tb.addIntervenant();
		assertEquals(tb.getNombreIntervenants(), new Integer(nb + 1));
	}

	@Test
	public void testremoveIntervenant()
	{
		int nb = tb.getNombreIntervenants();
		tb.removeIntervenant();
		assertEquals(tb.getNombreIntervenants(), new Integer(nb - 1));
	}

	@Test
	public void testgetNombreIntervenant()
	{
		assertTrue(tb.getNombreIntervenants() instanceof Integer);
		assertTrue(tb.getNombreIntervenants() >= 0);
	}

	@Test
	public void testdemarrerSimulation()
	{
	}

	@Test
	public void testarreterSimulation()
	{
	}

	/*@Test
	public void testreinitialiser()
	{
		tb.reinitialiser();

		assertEquals(tb.getTempsPassageMoyen(), new Integer(0));
		assertEquals(tb.getNombreVehiculeEnAttente(), new Integer(0));
		assertEquals(tb.getNombreBornes(), new Integer(0));

	}*/

	@Test
	public void testgetNombreBornes()
	{
		assertTrue(tb.getNombreBornes() instanceof Integer);
		assertTrue(tb.getNombreBornes() >= 0);
	}

	@Test
	public void testgetDebitEntree()
	{
		assertTrue(tb.getDebitEntree() instanceof Float);
		assertTrue(tb.getDebitEntree() >= 0);
	}

	@Test
	public void testgetTempsPassageMoyenParTypeDeBorne()
	{
		try
		{
			assertTrue(tb.getTempsPassageMoyenParTypeDeBorne("Automatique") instanceof Float);
			assertTrue(tb.getTempsPassageMoyenParTypeDeBorne("Manuelle") instanceof Float);
			assertTrue(tb.getTempsPassageMoyenParTypeDeBorne("Telepeage") instanceof Float);
			assertTrue(tb.getTempsPassageMoyenParTypeDeBorne("Automatique") >= 0);
			assertTrue(tb.getTempsPassageMoyenParTypeDeBorne("Manuelle") >= 0);
			assertTrue(tb.getTempsPassageMoyenParTypeDeBorne("Telepeage") >= 0);
		} catch (NotAValidBorneTypeException e)
		{
			fail();
		}
		try
		{
			tb.getTempsPassageMoyenParTypeDeBorne("To be alive");
			fail();
		} catch (NotAValidBorneTypeException e)
		{

		}
		try
		{
			assertFalse(tb.getTempsInnocupationBorne("") instanceof Float);
			fail();
		} catch (NotAValidBorneTypeException e)
		{
		}
	}

	@Test
	public void testgetTempsInnocupationBorne()
	{
		try
		{
			assertTrue(tb.getTempsInnocupationBorne("Automatique") instanceof Float);
			assertTrue(tb.getTempsInnocupationBorne("Manuelle") instanceof Float);
			assertTrue(tb.getTempsInnocupationBorne("TelePeage") instanceof Float);
			assertTrue(tb.getTempsInnocupationBorne("Automatique") >= 0);
			assertTrue(tb.getTempsInnocupationBorne("Manuelle") >= 0);
			assertTrue(tb.getTempsInnocupationBorne("TelePeage") >= 0);
		} catch (NotAValidBorneTypeException e)
		{
			fail();
		}
		try
		{
			tb.getTempsInnocupationBorne("To be alive");
			fail();
		} catch (NotAValidBorneTypeException e)
		{
		}
		try
		{
			assertFalse(tb.getTempsInnocupationBorne("") instanceof Float);
			fail();
		} catch (NotAValidBorneTypeException e)
		{
		}
	}

	public void testgetNextNumeroBorne()
	{
		assertTrue(tb.getNextNumeroBorne() instanceof Integer);
		assertTrue(tb.getNextNumeroBorne() >= 0);
		assertTrue(tb.getNextNumeroBorne() <= tb.getNombreBornes() + 1);

	}
}
