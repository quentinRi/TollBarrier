package tollBarrier.bornes;
import java.util.HashSet;

import tollBarrier.vehicule.MoyenDePaiment;

public class BoTelePeage extends Borne{

	public BoTelePeage(){

		super();	
		_payment = new HashSet<MoyenDePaiment>();
		_payment.add(MoyenDePaiment.TELEPEAGE);	
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
