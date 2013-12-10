/* 
 * ENSICAEN
 * 6 Boulevard Marechal Juin 
 * F-14050 Caen Cedex 
 *
 * This file is owned by ENSICAEN students.
 * No portion of this document may be reproduced, copied
 * or revised without written permission of the authors.
 */ 
/**
 * @author Gaëtan Le Barbé gaetan.lebarbe@ecole.ensicaen.fr
 * @version 0.0.1
 * @date 3 déc. 2013
 */
package tollBarrier.barrier;

import tollBarrier.bornes.exceptions.NotAValidBorneTypeException;
import tollBarrier.vehicule.MoyenDePaiment;

/**
 * @author lebarbe
 *
 */
public class TollBarrier
{
	
	/**
	 * @return
	 */
	public void addDebit(typeVehicule v, Integer nbParMinute, MoyenDePaiment mdp)
	{
		// TODO Auto-generated method stub
	
	}

	/**
	 * @return
	 */
	public Float getTempsPassageMoyen()
	{
		for()
	}

	/**
	 * @return
	 */
	public Float getTempsPassageMoyenParBorne(Integer i)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Integer getNombreVehiculeEnAttente()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public void addIntervenant()
	{
		// TODO Auto-generated method stub
	
	}
	
	public void demarrerSimulation()
	{
		// TODO Auto-generated method stub
	
	}
	
	public void arreterSimulation()
	{
		// TODO Auto-generated method stub
	
	}
	
	public void reinitialiser()
	{
		// TODO Auto-generated method stub
	
	}
	
	public void addBorne(String typeborne, MoyenDePaiment mdp)
	{
		// TODO Auto-generated method stub
	
	}

	/**
	 * @return
	 */
	public Integer getNombreBornes(String typeBorne)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @return
	 */
	public Integer getNombreBornes()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Float getDebitEntree()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Float getTempsPassageMoyenParTypeDeBorne(String borne) throws NotAValidBorneTypeException
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Float getTempsInnocupationBorne(String typeborne) throws NotAValidBorneTypeException
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Integer getNombreIntervenants()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	public void removeIntervenant()
	{
		// TODO Auto-generated method stub
		
	}
	
	public Integer getNextNumeroBorne()
	{
		// TODO Auto-generated method stub
		
	}

}
