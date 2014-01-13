package tollBarrier.bornes.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tollBarrier.bornes.BoAutomatique;
import tollBarrier.bornes.BoManuelle;
import tollBarrier.bornes.BoTelePeage;
import tollBarrier.bornes.FabriqueDeBorne;
import tollBarrier.bornes.exceptions.NotAValidBorneTypeException;

public class TestFabriqueDeBorne
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test()
	{
		fail("Not yet implemented");
	}

	public void testCreerBorne()
	{

		FabriqueDeBorne f = new FabriqueDeBorne();

		try
		{
			assertTrue(f.creerBorne("Manuelle") instanceof BoManuelle);
		} catch (NotAValidBorneTypeException e)
		{
			fail("Exception inattendue");
		}
		try
		{
			assertTrue(f.creerBorne("Telepeage") instanceof BoTelePeage);
		} catch (NotAValidBorneTypeException e)
		{
			fail("Exception inattendue");
		}
		try
		{
			assertTrue(f.creerBorne("Automatique") instanceof BoAutomatique);
		} catch (NotAValidBorneTypeException e)
		{
			fail("Exception inattendue");
		}
		try
		{
			assertTrue(f.creerBorne("x") == null);
			fail("Exception attendue non survenue");
		} catch (NotAValidBorneTypeException e)
		{
		}
	}
}
