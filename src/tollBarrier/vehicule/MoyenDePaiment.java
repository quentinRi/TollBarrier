package tollBarrier.vehicule;

public enum MoyenDePaiment
{	
	CB(3), ABONNEMENT(3), LIQUIDE(5), TELEPEAGE(1);
	
	private int timeMultiplier;
	
	MoyenDePaiment(int timeMultiplier)
	{
		this.timeMultiplier = timeMultiplier;
	}

	public static MoyenDePaiment getByName(String type)
	{
		switch (type.toLowerCase().charAt(0))
		{
		case 'c':
			return CB;
		case 'a':
			return ABONNEMENT;
		case 'l':
			return LIQUIDE;
		case 't':
			return TELEPEAGE;
		}
		return null;
	}

	public int getTimeMultiplier()
	{
		return timeMultiplier;
	}
}
