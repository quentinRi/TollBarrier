package tollBarrier.vehicule.vehiculesObjects;

import java.util.Set;

import tollBarrier.vehicule.MoyenDePaiment;

public class Camion extends Vehicule
{

	public Camion(Set<MoyenDePaiment> mdp)
	{
		super(mdp);
	}
	

	public long getTimeMuliplier()
	{
		return 10;
	}

}
