package tollBarrier.vehicule.vehiculesObjects;

import java.util.Random;
import java.util.Set;

import tollBarrier.vehicule.MoyenDePaiment;

public class Camion extends Vehicule
{

	public Camion(Set<MoyenDePaiment> mdp)
	{
		super(mdp);
		_amount = new Random().nextInt(51) +10;
	}
	
	
	public long getTimeMuliplier()
	{
		return 10;
	}

}
