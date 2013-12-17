package tollBarrier.bornes;
import java.util.HashSet;

import tollBarrier.vehicule.MoyenDePaiment;

public class BoManuelle extends Borne{

	public BoManuelle(){

		super();
		_payment = new HashSet<MoyenDePaiment>();
		_payment.add(MoyenDePaiment.CB);
		_payment.add(MoyenDePaiment.LIQUIDE);
		_payment.add(MoyenDePaiment.ABONNEMENT);
	}
	
	public void leverBarriere(){
		
		_paymentAccepte = demanderAccord();
		if(_paymentAccepte)
			_barriereLevee = true;
	}

/*
	public void envoyerRapport(){
		
		
	}
*/
	
}
