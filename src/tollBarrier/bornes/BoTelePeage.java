package tollBarrier.bornes;
import java.util.HashSet;

import tollBarrier.vehicule.MoyenDePaiment;

public class BoTelePeage extends Borne{

	public BoTelePeage(){

		super();	
		_paiement = new HashSet<MoyenDePaiment>();
		_paiement.add(MoyenDePaiment.Telepeage);	
	}
	
/*
	public void envoyerRapport(){
		
	}
*/
	public void paiment(){
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}

	@Override
	public void run() {

		paiment();
		
		envoyerRapport();
		leverBarriere();

		_vehicule.quitterPeage();
		long tmp = _vehicule.getTempsPassage();
		calculerTmpMoyen(tmp);
		_vehicule = null;
	}
}
