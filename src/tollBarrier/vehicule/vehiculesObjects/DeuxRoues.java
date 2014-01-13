package tollBarrier.vehicule.vehiculesObjects;

import java.util.Set;

import tollBarrier.vehicule.MoyenDePaiment;

public class DeuxRoues extends Vehicule
{

	public DeuxRoues(Set<MoyenDePaiment> mdp)
	{
		super(mdp);
	}

	public long getTimeMuliplier()
	{
		return 5;
	}

}
