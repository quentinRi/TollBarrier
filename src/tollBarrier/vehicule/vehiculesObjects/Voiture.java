package tollBarrier.vehicule.vehiculesObjects;

import java.util.Random;
import java.util.Set;

import tollBarrier.vehicule.MoyenDePaiment;

public class Voiture extends Vehicule
{

	public Voiture(Set<MoyenDePaiment> mdp)
	{
		super(mdp);
		_amount = new Random().nextInt(36) +5;
	}

	public long getTimeMuliplier()
	{
		return 7;
	}
}
