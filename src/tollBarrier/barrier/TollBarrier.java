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

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import tollBarrier.bornes.BoAutomatique;
import tollBarrier.bornes.BoManuelle;
import tollBarrier.bornes.BoTelePeage;
import tollBarrier.bornes.Borne;
import tollBarrier.bornes.exceptions.NotAValidBorneTypeException;
import tollBarrier.vehicule.MoyenDePaiment;

import java.util.ArrayList;

import tollBarrier.vehicule.exceptions.PasDeVehiculeTrouveException;
import tollBarrier.vehicule.vehiculesObjects.Camion;
import tollBarrier.vehicule.vehiculesObjects.Vehicule;

public class TollBarrier
{
	private static TollBarrier instance;

	private LinkedList<Borne> bornes;
	private LinkedList<Vehicule> vehicules;
	private ArrayList<Debit> debits;

	private TollBarrier()
	{
		bornes = new LinkedList<Borne>();
		vehicules = new LinkedList<Vehicule>();
		debits = new ArrayList<Debit>();
	}
	
	public static void reset()
	{
		instance = new TollBarrier();		
	}
	
	/**
	 * @return
	 */
	public void addDebit(String typeVehicule, Integer nbParMinute,
			Collection<String> typePaiement)
	{
		for (String s : typePaiement)
			debits.add(new Debit(typeVehicule, nbParMinute, s, vehicules, this));
	}

	public void addDebit(String typeVehicule, Integer nbParMinute, HashSet<MoyenDePaiment> mdp)
	{
		for (MoyenDePaiment m : mdp)
			debits.add(new Debit(typeVehicule, nbParMinute, m.name(), vehicules, this));
	}
	
	public static TollBarrier getInstance()
	{
		if (instance == null)
			instance = new TollBarrier();
		return instance;
	}

	public void addBorne(String typeborne)
	{
		switch (typeborne.toLowerCase().charAt(0))
		{
		case 'm':
			bornes.add(new BoManuelle());
			break;
		case 'a':
			bornes.add(new BoAutomatique());
			break;
		case 't':
			bornes.add(new BoTelePeage());
			break;
		}
	}

	public boolean getVehicule(Borne borne) throws PasDeVehiculeTrouveException
	{
		synchronized (vehicules)
		{
			LinkedList<Vehicule> vehiculesCopy = new LinkedList<Vehicule>(
					vehicules);
			for (Vehicule v : vehiculesCopy)
			{
				if (v instanceof Camion && !(borne instanceof BoManuelle))
					continue;
				for (MoyenDePaiment mdp : v.getMoyensDePaiment())
					if (borne.getMoyensDePaiment().contains(mdp))
					{
						borne.setVehicule(vehicules.remove(vehiculesCopy
								.indexOf(v)));
						System.out.println(v
								+ " commence à passer à la borne " + borne);
						return true;
					}
			}
			return false;
		}
		/*
		 * // Recupération des moyens de paiement acceptés par la borne
		 * demandeuse // de véhicule Set<MoyenDePaiment> bmdp =
		 * borne.getMoyensDePaiment();
		 * 
		 * // Pour chaque véhicule dans la file for (int i = 0; i <
		 * file.size(); i++) {
		 * 
		 * // On récupère ses moyens de paiement possibles Set<MoyenDePaiment>
		 * vmdp = file.get(i).getMoyensDePaiment();
		 * 
		 * // On vérifie si ce véhicule peut aller dans la borne demandeuse
		 * for (MoyenDePaiment mv : vmdp)
		 * 
		 * // Si le véhicule correpsond, on l'envoie à la borne if
		 * (bmdp.contains(mv)) { Vehicule v = file.get(i); file.remove(i);
		 * return v; } }
		 * 
		 * // Si aucun véhicule dans la file ne correspond, on renvoie une //
		 * exception String s = "Pas de Véhicule ac mdp: " + bmdp;
		 * 
		 * throw new PasDeVehiculeTrouveException(s);
		 */
	}

	/**
	 * @return
	 */
	/*
	 * public Float getTempsPassageMoyen() { int nbBornes = getNombreBornes();
	 * float sum = 0;
	 * 
	 * for (int i = 0; i < nbBornes; i++) { sum +=
	 * getTempsPassageMoyenParBorne(i); } return sum / nbBornes; TODO }
	 */

	/**
	 * @return
	 */
	/*
	 * public Float getTempsPassageMoyenParBorne(int numBorne) { Borne borne =
	 * bornes.get(numBorne); return borne.getTempsPassage(); TODO }
	 */

	/**
	 * @return
	 */
	public Integer getNombreVehiculeEnAttente()
	{
		return vehicules.size();
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
	public Float getTempsPassageMoyenParTypeDeBorne(String borne)
			throws NotAValidBorneTypeException
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Float getTempsInnocupationBorne(String typeborne)
			throws NotAValidBorneTypeException
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
		return null;
	}

	public static void main(String[] args)
	{
		TollBarrier barriere = getInstance();

		Scanner sc = new Scanner(System.in);

		System.out.println("Combien de débits ?");
		int nbDebits = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < nbDebits; i++)
		{
			System.out.println("Débit " + i);
			System.out
					.println("Quel type de véhicules ((V)oiture,(C)amion,(D)eux-roues) ?");
			String typeV = sc.nextLine();
			System.out.println("Combien de véhicules par minute ?");
			int nbV = Integer.parseInt(sc.nextLine());
			System.out
					.println("Quel Moyen de paiment ((C)B,(A)bonnement,(L)iquide,(T)elepeage) ?");
			String typeP = sc.nextLine();
			HashSet<String> typesP = new HashSet<String>();
			typesP.add(typeP);
			barriere.addDebit(typeV, nbV, typesP);
		}

		System.out.println("Combien de bornes ?");
		int nbBornes = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < nbBornes; i++)
		{
			System.out.println("Borne " + i);
			System.out
					.println("Quel type de borne (T)elepeage, (A)utomatique, (M)anuelle ?");
			String typeB = sc.nextLine();

			barriere.addBorne(typeB);
		}

		sc.close();

		for (Borne b : barriere.bornes)
			b.start();

		for (Debit d : barriere.debits)
		{
			d.start();
		}
	}

	public void add(Vehicule v)
	{
		synchronized (vehicules)
		{
			vehicules.add(v);
			System.out.println(v + " arrive au péage");
		}
	}
}
