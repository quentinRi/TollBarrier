package tollBarrier.barrier.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tollBarrier.barrier.TollBarrier;

public class TollBarrierTest
{
	TollBarrier tb;
	
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

	@Test
	public void testTempsPassageMoyen()
	{
		assertTrue(tb.getTempsPassageMoyen() instanceof Float);
		assertTrue (tb.getNombreBornes()>=0);
		int nbBornes=tb.getNombreBornes();
		float tempsPassageMoyen = 0 ;
		for(int i=0; i<nbBornes; i++)
		{
			tempsPassageMoyen+=tb.getTempsPassageMoyenParBorne(i);
		}
			tempsPassageMoyen/=nbBornes;
		assertTrue (tempsPassageMoyen==tb.getTempsPassageMoyen());
		
			
	}
	
	@Test
	public void testTempsPassageMoyenParBorne()
	{
		assertTrue(tb.getTempsPassageMoyenParBorne(0) instanceof Float);
		int nbBornes=tb.getNombreBornes();
		for(int i=0; i<nbBornes; i++)
		{
			assertTrue (tb.getTempsPassageMoyenParBorne(i)>=0);
		}
	}
	
	@Test
	public void testNombreVehiculeEnAttente()
	{
		assertTrue(tb.getNombreVehiculeEnAttente() instanceof Integer);
		assertTrue (tb.getNombreVehiculeEnAttente()>=0);
	}
	
	@Test
	public void testaddIntervenant()
	{
		int nb = tb.getNombreIntervenants();
		tb.addIntervenant();
		assertEquals(tb.getNombreIntervenants(),new Integer(nb+1));
	}
	
	@Test
	public void testremoveIntervenant()
	{
		int nb = tb.getNombreIntervenants();
		tb.removeIntervenant();
		assertEquals(tb.getNombreIntervenants(),new Integer(nb-1));
	}
	
	@Test
	public void testgetNombreIntervenant()
	{
		assertTrue(tb.getNombreIntervenants() instanceof Integer);
		assertTrue (tb.getNombreIntervenants()>=0);
	}
	
	@Test
	public void testdemarrerSimulation()
	{
	}
	
	@Test
	public void testarreterSimulation()
	{	
	}
	
	@Test
	public void testreinitialiser()
	{
		tb.reinitialiser();

		assertEquals(tb.getTempsPassageMoyen(),new Integer(0));
		assertEquals(tb.getNombreVehiculeEnAttente(),new Integer(0));
		assertEquals(tb.getNombreBornes(),new Integer(0));
		
	}
	
	@Test
	public void testgetNombreBornes()
	{
		assertTrue(tb.getNombreBornes() instanceof Integer);
		assertTrue (tb.getNombreBornes()>=0);
	}
	
	@Test
	public void testgetDebitEntree()
	{
		assertTrue(tb.getDebitEntree() instanceof Float);
		assertTrue (tb.getDebitEntree()>=0);
	}
	
	@Test
	public void testgetTempsPassageMoyenParTypeDeBorne()
	{
		assertTrue(tb.getTempsPassageMoyenParTypeDeBorne() instanceof Float);
		assertTrue (tb.getTempsPassageMoyenParTypeDeBorne()>=0);
	}
	
	@Test
	public void testgetTempsInnocupationBorne()
	{
		assertTrue(tb.getTempsInnocupationBorne() instanceof Float);
		assertTrue (tb.getTempsInnocupationBorne()>=0);
	}


	@Test
	public void testgetNombreBornes()
	{
		assertTrue(tb.getNombreBornes() instanceof Integer);
		assertTrue (tb.getNombreBornes()>=0);
	}
}
