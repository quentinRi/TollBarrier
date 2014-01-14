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
 * @date 17 déc. 2013
 */
package tollBarrier.barrier;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import tollBarrier.vehicule.FabriqueDeVehicule;
import tollBarrier.vehicule.MoyenDePaiment;
import tollBarrier.vehicule.vehiculesObjects.Vehicule;

/**
 * @author lebarbe
 * 
 */
public class Debit extends Thread
{
	private String				typeVehicule;
	private Collection<String> 	typePaiement;
	private int					nbParMn;
	private TollBarrier			tb;
	private boolean				accFlag;

	/**
	 * @param typeVehicule
	 * @param nbParMinute
	 * @param typePaiement
	 * @param vehicules
	 */
	public Debit(String typeVehicule, Integer nbParMinute, Collection<String> typePaiement,
			Collection<Vehicule> vehicules, TollBarrier tb)
	{
		this.typePaiement = typePaiement;
		this.typeVehicule = typeVehicule;
		this.nbParMn = nbParMinute;
		this.tb = tb;
		this.accFlag = false;
	}

	public Debit(String typeVehicule, Integer nbParMinute,
			HashSet<MoyenDePaiment> mdp, LinkedList<Vehicule> vehicules,
			TollBarrier tb)
	{
		this.typePaiement = new HashSet<String>();
		for (MoyenDePaiment moyen : mdp)
			typePaiement.add(moyen.name());
		this.typeVehicule = typeVehicule;
		this.nbParMn = nbParMinute;
		this.tb = tb;
		this.accFlag = false;
	}

	public void accelerate(){
		accFlag = !accFlag;
	}
	
	@Override
	public void run()
	{
		int n = nbParMn;
		while (TollBarrier.isRunning())
		{
			HashSet<MoyenDePaiment> moyens = new HashSet<MoyenDePaiment>();
			for (String mdp : typePaiement)
			moyens.add(MoyenDePaiment.getByName(mdp));
			Vehicule v = FabriqueDeVehicule.getInstance().creerVehicule(typeVehicule, moyens);
			tb.add(v);
			
			if(accFlag) n = nbParMn/10;
			else n = nbParMn;
			try
			{
				Thread.sleep(60000 / n);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public int getNb()
	{
		return nbParMn;
	}
	
	public String toString()
	{
		return nbParMn + " " + typeVehicule + " dot�s de: " + typePaiement;
	}

}
