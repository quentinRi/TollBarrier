package tollBarrier.vehicule.vehiculesObjects;

import java.util.Set;

import tollBarrier.vehicule.MoyenDePaiment;

public class Voiture extends Vehicule
{

	public Voiture(Set<MoyenDePaiment> mdp)
	{
		super(mdp);
	}

	public long getTime()
	{
		return 7000;
	}
}
