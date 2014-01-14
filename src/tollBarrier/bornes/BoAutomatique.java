package tollBarrier.bornes;

import java.util.HashSet;

import tollBarrier.vehicule.MoyenDePaiment;

public class BoAutomatique extends Borne
{
	public BoAutomatique()
	{
		super();
		_paiement = new HashSet<MoyenDePaiment>();
		_paiement.add(MoyenDePaiment.CB);
		_paiement.add(MoyenDePaiment.LIQUIDE);
		_paiement.add(MoyenDePaiment.ABONNEMENT);
	}

	@Override
	public final String getType()
	{
		return "Automatique";
	}
}
