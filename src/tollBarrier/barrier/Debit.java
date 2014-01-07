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

import tollBarrier.vehicule.FabriqueDeVehicule;
import tollBarrier.vehicule.MoyenDePaiment;
import tollBarrier.vehicule.vehiculesObjects.Vehicule;

/**
 * @author lebarbe
 * 
 */
public class Debit extends Thread
{
	private FabriqueDeVehicule	fabrique	= FabriqueDeVehicule.getInstance();	;
	private String				typeVehicule;
	private String				typePaiement;
	private int					nbParMn;
	private TollBarrier			tb;

	/**
	 * @param typeVehicule
	 * @param nbParMinute
	 * @param typePaiement
	 * @param vehicules
	 */
	public Debit(String typeVehicule, Integer nbParMinute, String typePaiement,
			Collection<Vehicule> vehicules, TollBarrier tb)
	{
		this.typePaiement = typePaiement;
		this.typeVehicule = typeVehicule;
		this.nbParMn = nbParMinute;
		this.tb = tb;
	}

	@Override
	public void run()
	{
		while (true)
		{
			HashSet<MoyenDePaiment> moyens = new HashSet<MoyenDePaiment>();
			moyens.add(MoyenDePaiment.getByName(typePaiement));
			Vehicule v = fabrique.creerVehicule(typeVehicule, moyens);
			tb.add(v);
			try
			{
				Thread.sleep(60000 / nbParMn);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}
