package tollBarrier.bornes;
import java.util.HashSet;

import tollBarrier.vehicule.MoyenDePaiment;


public class BoManuelle extends Borne{

	
	public BoManuelle(){

		super();
		_paiement = new HashSet<MoyenDePaiment>();
		_paiement.add(MoyenDePaiment.CB);
		_paiement.add(MoyenDePaiment.LIQUIDE);
		_paiement.add(MoyenDePaiment.ABONNEMENT);
	}
	
	
	public void envoyerRapport(){

	}	
}
