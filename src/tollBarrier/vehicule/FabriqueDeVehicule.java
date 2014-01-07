package tollBarrier.vehicule;

import java.util.Set;

import tollBarrier.vehicule.vehiculesObjects.Camion;
import tollBarrier.vehicule.vehiculesObjects.DeuxRoues;
import tollBarrier.vehicule.vehiculesObjects.Vehicule;
import tollBarrier.vehicule.vehiculesObjects.Voiture;

public class FabriqueDeVehicule
{
	private static FabriqueDeVehicule instance;

	private FabriqueDeVehicule()
	{
	}
	
	public static FabriqueDeVehicule getInstance()
	{
		if (instance == null)
			instance = new FabriqueDeVehicule();
		return instance;
	}

	public Vehicule creerVehicule(String type, Set<MoyenDePaiment> mdp)
	{
		char t = type.toLowerCase().charAt(0);
		switch (t)
		{
		case 'c':
			return new Camion(mdp);
		case 'd':
			return new DeuxRoues(mdp);
		case 'v':
			return new Voiture(mdp);
		default:
			return null;
		}
	}
}
