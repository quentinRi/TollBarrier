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

import java.util.LinkedList;

import tollBarrier.bornes.Borne;
import tollBarrier.bornes.exceptions.NotAValidBorneTypeException;
import tollBarrier.vehicule.MoyenDePaiment;
import java.util.ArrayList;
import java.util.HashSet;

import tollBarrier.vehicule.Vehicule;

public class TollBarrier
{
	private static TollBarrier instance;

	private LinkedList<Borne> bornes;
	private LinkedList<Vehicule> vehicules;
	private ArrayList<Debit> debits;
	
	public TollBarrier()
	{
		bornes = new LinkedList<Borne>();
		vehicules = new LinkedList<Vehicule>();
		debits = new ArrayList<Debit>();
	}
	
	/**
	 * @return
	 */
	public void addDebit(String typeVehicule, Integer nbParMinute, String typePaiement)
	{
		debits.add(new Debit(typeVehicule, nbParMinute, typePaiement));
		
	}


	public static TollBarrier getInstance() {
		if (instance == null)
			instance = new TollBarrier();
		return instance;
	}

	/**
	 * @return
	 */
	public void addDebit(String typeVehicule, Integer nbParMinute,
			MoyenDePaiment mdp) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return
	 */
	public Float getTempsPassageMoyen() {
		int nbBornes = getNombreBornes();
		float sum = 0;

		for (int i = 0; i < nbBornes; i++) {
			sum += getTempsPassageMoyenParBorne(i);
		}
		return sum / nbBornes;

	}

	/**
	 * @return
	 */
	public Float getTempsPassageMoyenParBorne(int numBorne) {
		Borne borne=bornes.get(numBorne);
		return borne.getTempsPassage();
	}

	/**
	 * @return
	 */
	public Integer getNombreVehiculeEnAttente() {
		int cpt = 0;
		while (vehiculeAttente != 0) {
			cpt += 1;
		}
		return cpt;
	}

	/**
	 * @return
	 */
	public void addIntervenant() {
		// TODO Auto-generated method stub

	}

	public void demarrerSimulation() {
		// TODO Auto-generated method stub

	}

	public void arreterSimulation() {
		// TODO Auto-generated method stub

	}

	public void reinitialiser() {
		// TODO Auto-generated method stub

	}

	public void addBorne(String typeborne, MoyenDePaiment mdp) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return
	 */
	public Integer getNombreBornes(String typeBorne) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Integer getNombreBornes() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Float getDebitEntree() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Float getTempsPassageMoyenParTypeDeBorne(String borne)
			throws NotAValidBorneTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Float getTempsInnocupationBorne(String typeborne)
			throws NotAValidBorneTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Integer getNombreIntervenants() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	public void removeIntervenant() {
		// TODO Auto-generated method stub

	}

	public Integer getNextNumeroBorne() {
		// TODO Auto-generated method stub
		return null;
	}

}
