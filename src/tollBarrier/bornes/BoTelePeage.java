package tollBarrier.bornes;
import java.util.HashSet;

import tollBarrier.vehicule.MoyenDePaiment;

public class BoTelePeage extends Borne{

	public BoTelePeage(){

		super();	
		_paiement = new HashSet<MoyenDePaiment>();
		_paiement.add(MoyenDePaiment.TELEPEAGE);	
	}
	
/*
	public void envoyerRapport(){
		
	}
*/
}
