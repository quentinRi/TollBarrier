package tollBarrier.vehicule;

import java.util.Set;

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

		switch (type)
		{
		case "Camion":
			return new Camion(mdp);
		case "DeuxRoues":
			return new DeuxRoues(mdp);
		case "Voiture":
			return new Voiture(mdp);
		default:
			return null;
		}
	}
}
