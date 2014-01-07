package tollBarrier.bornes;

public class FabriqueDeBorne
{

	public FabriqueDeBorne()
	{

	}

	public Borne creerBorne(String type)
	{
		char t = type.toLowerCase().charAt(0);
		switch (t)
		{
		case 'm':
			return new BoManuelle();
		case 't':
			return new BoTelePeage();
		case 'a':
			return new BoAutomatique();
		default:
			return null;

		}
	}
}
