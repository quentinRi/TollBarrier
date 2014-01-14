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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tollBarrier.bornes.BoManuelle;
import tollBarrier.bornes.Borne;
import tollBarrier.bornes.FabriqueDeBorne;
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
	private List<TollBarrierListener> listeners;
	private long _tempsDebutSimulation;
	private static boolean running = false;

	public static boolean isRunning()
	{
		return running;
	}

	private TollBarrier()
	{
		bornes = new LinkedList<Borne>();
		vehicules = new LinkedList<Vehicule>();
		debits = new ArrayList<Debit>();
		listeners = new ArrayList<TollBarrierListener>();
	}

	/**
	 * @return
	 */
	public void addDebit(String typeVehicule, Integer nbParMinute,
			Collection<String> typePaiement)
	{
		debits.add(new Debit(typeVehicule, nbParMinute, typePaiement,
				vehicules, this));
	}

	public void addDebit(String typeVehicule, Integer nbParMinute,
			HashSet<MoyenDePaiment> mdp)
	{
		debits.add(new Debit(typeVehicule, nbParMinute, mdp, vehicules, this));
	}

	public List<Debit> getListDebit()
	{
		return debits;
	}

	public static TollBarrier getInstance()
	{
		if (instance == null)
			instance = new TollBarrier();
		return instance;
	}

	public void addBorne(String typeborne)
	{
		try
		{
			Borne b = new FabriqueDeBorne().creerBorne(typeborne);
			bornes.add(b);
			for (TollBarrierListener listener : listeners)
				listener.updateBornes();
			if (running)
				b.start();
		} catch (NotAValidBorneTypeException e)
		{
			e.printStackTrace();
		}
	}

	public void rmBorne(String string)
	{
		Iterator<Borne> iterator = bornes.iterator();
		while (iterator.hasNext())
		{
			Borne b = iterator.next();
			if (b.getType().toLowerCase().charAt(0) == string.toLowerCase()
					.charAt(0))
			{
				b.stopIt();
				iterator.remove();
				for (TollBarrierListener listener : listeners)
					listener.updateBornes();
				return;
			}
		}
	}

	public static boolean compatible(Borne borne, Vehicule vehicule)
	{
		if (vehicule instanceof Camion && !(borne instanceof BoManuelle))
			return false;
		for (MoyenDePaiment mdp : vehicule.getMoyensDePaiment())
			if (borne.getMoyensDePaiment().contains(mdp))
			{
				return true;
			}
		return false;
	}

	public Vehicule getVehicule(Borne borne)
			throws PasDeVehiculeTrouveException
	{
		synchronized (vehicules)
		{
			if (vehicules == null || vehicules.isEmpty())
				throw new PasDeVehiculeTrouveException();
			LinkedList<Vehicule> vehiculesCopy = new LinkedList<Vehicule>(
					vehicules);
			for (Vehicule v : vehiculesCopy)
			{
				if (compatible(borne, v))
				{
					Vehicule retour = vehicules
							.remove(vehiculesCopy.indexOf(v));
					for (TollBarrierListener listener : listeners)
						listener.updateVehiculesEnAttente();
					return retour;
				}
			}
			throw new PasDeVehiculeTrouveException();
		}
	}

	public synchronized void envoyerRapport()
	{
		for (TollBarrierListener listener : listeners)
			listener.updateTempsPassageMoyen();
	}

	public Double getTempsPassageMoyen()
	{
		double tempsTotal = 0;
		double nbVeh = 0;
		for (int i = 0; i < getNombreBornes(); i++)
		{
			double nbVehAtBorne = bornes.get(i).getNbVeh();
			if (nbVehAtBorne > 0)
			{
				tempsTotal += bornes.get(i).getTime();
				nbVeh += nbVehAtBorne;
			}
		}
		return tempsTotal / nbVeh;
	}

	public long getArgentEncaisse()
	{
		long argentTotal = 0;

		for (int i = 0; i < getNombreBornes(); i++)
		{
			argentTotal += bornes.get(i).getArgentEncaisse();
		}
		return argentTotal;
	}
	
	public Float getArgentEncaisseMoyen()
	{
		return (new Float(getArgentEncaisse()) / getNombreBornes());
	}

	/**
	 * @return
	 */
	public Integer getNombreVehiculeEnAttente()
	{
		return vehicules.size();
	}

	public void demarrerSimulation()
	{
		running = true;
		_tempsDebutSimulation = System.currentTimeMillis() / 1000;
		for (Borne b : bornes)
			b.start();
		for (Debit d : debits)
			d.start();
		for (TollBarrierListener listener : listeners)
			listener.startRunning();
	}

	public static void reset()
	{
		instance = new TollBarrier();
		instance.arreterSimulation();
	}

	public void arreterSimulation()
	{
		running = false;
		for (TollBarrierListener listener : listeners)
			listener.stopRunning();
		for (TollBarrierListener listener : listeners)
			listener.updateTempsPassageMoyen();
	}

	/**
	 * @return
	 */
	public Integer getNombreBornes(String typeBorne)
	{
		int nb = 0;
		for (Borne b : bornes)
			if (b.getType().toLowerCase().charAt(0) == typeBorne.toLowerCase()
					.charAt(0))
				nb++;
		return nb;
	}

	/**
	 * @return
	 */
	public Integer getNombreBornes()
	{
		return bornes.size();
	}

	public LinkedList<Borne> getBornes () {
		return bornes;
	}
	
	public Integer getDebitEntree()
	{
		int nbVehParMn = 0;
		for (Debit d : debits)
			nbVehParMn += d.getNb();
		return nbVehParMn;
	}

	public Float getTempsPassageMoyenParTypeDeBorne(String borne)
			throws NotAValidBorneTypeException
	{
		Float total = new Float(0);
		int nbBornes = 0;
		for (Borne b : bornes)
			if(b.getType().toLowerCase().charAt(0) == borne.toLowerCase().charAt(0))
			{
				nbBornes++;
				total +=  new Float(b.getTempsPassageMoyen());
			}
		
		return total/nbBornes;
	}

	public Float getTempsInnocupationBorne(String typeborne)
			throws NotAValidBorneTypeException
	{
		Float total = new Float(0);
		int nbBornes = 0;
		for (Borne b : bornes)
			if(b.getType().toLowerCase().charAt(0) == typeborne.toLowerCase().charAt(0))
			{
				nbBornes++;
				total +=  new Float(b.getIdleTime());
			}
		
		return total/nbBornes;
	}

	/*
	 * public static void main(String[] args) { TollBarrier barriere =
	 * getInstance();
	 * 
	 * Scanner sc = new Scanner(System.in);
	 * 
	 * System.out.println("Combien de débits ?"); int nbDebits =
	 * Integer.parseInt(sc.nextLine()); for (int i = 0; i < nbDebits; i++) {
	 * System.out.println("Débit " + i); System.out
	 * .println("Quel type de véhicules ((V)oiture,(C)amion,(D)eux-roues) ?");
	 * String typeV = sc.nextLine();
	 * System.out.println("Combien de véhicules par minute ?"); int nbV =
	 * Integer.parseInt(sc.nextLine()); System.out
	 * .println("Quel Moyen de paiment ((C)B,(A)bonnement,(L)iquide,(T)elepeage) ?"
	 * ); String typeP = sc.nextLine(); HashSet<String> typesP = new
	 * HashSet<String>(); typesP.add(typeP); barriere.addDebit(typeV, nbV,
	 * typesP); }
	 * 
	 * System.out.println("Combien de bornes ?"); int nbBornes =
	 * Integer.parseInt(sc.nextLine()); for (int i = 0; i < nbBornes; i++) {
	 * System.out.println("Borne " + i); System.out
	 * .println("Quel type de borne (T)elepeage, (A)utomatique, (M)anuelle ?");
	 * String typeB = sc.nextLine();
	 * 
	 * barriere.addBorne(typeB); }
	 * 
	 * sc.close();
	 * 
	 * for (Borne b : barriere.bornes) b.start();
	 * 
	 * for (Debit d : barriere.debits) d.start(); }
	 */

	public void add(Vehicule v)
	{
		synchronized (vehicules)
		{
			vehicules.add(v);
			System.out.println(v + " arrive au péage");
			for (TollBarrierListener listener : listeners)
				listener.updateVehiculesEnAttente();
		}
	}

	public void addListener(TollBarrierListener listener)
	{
		listeners.add(listener);
	}
}
