package tollBarrier.bornes;
import java.util.ArrayList;
import tollBarrier.vehicule.MoyenDePaiment;

import java.util.ArrayList;

import tollBarrier.vehicule.MoyenDePaiment;

public class BoManuelle extends Borne{

	public BoManuelle(){

		super();
		_payment = new ArrayList<MoyenDePaiment>();
		_payment.add(MoyenDePaiment.CB);
		_payment.add(MoyenDePaiment.Liquide);
		_payment.add(MoyenDePaiment.Abonnement);
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
	public boolean demanderAccord(){
		return false;
	}
	
}
