package tollBarrier.vehicule;

public enum MoyenDePaiment
{
	CB, ABONNEMENT, LIQUIDE, TELEPEAGE;

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
}
