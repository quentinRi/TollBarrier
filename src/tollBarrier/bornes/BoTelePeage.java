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
	
/*
	@Override
	public void run() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
		
		envoyerRapport();
		leverBarriere();

		_vehicule.quitterPeage();
		long tmp = _vehicule.getTempsPassage();
		calculerTmpMoyen(tmp);
		_vehicule = null;
	}*/
}
