package tollBarrier.bornes;
import java.util.ArrayList;
import tollBarrier.vehicule.MoyenDePaiment;

public class BoTelePeage extends Borne{

	public BoTelePeage(){

		super();	
		_payment = new ArrayList<MoyenDePaiment>();
		_payment.add(MoyenDePaiment.Telepeage);	
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
