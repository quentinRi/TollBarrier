package tollBarrier.vehicule;

import java.util.Set;

public class Camion extends Vehicule
{

	public Camion(Set<MoyenDePaiment> mdp)
	{
		super(mdp);
	}
	

	public long getTime()
	{
		return 10;
	}

}
