package tollBarrier.vehicule.vehiculesObjects;

import java.util.Random;
import java.util.Set;

import tollBarrier.vehicule.MoyenDePaiment;

public class DeuxRoues extends Vehicule
{

	public DeuxRoues(Set<MoyenDePaiment> mdp)
	{
		super(mdp);
		_amount = new Random().nextInt(36) +5;
	}

	public long getTimeMuliplier()
	{
		return 5;
	}

}
