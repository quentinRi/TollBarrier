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
	public void paiement(){
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}

	public void alarme(){
		
		try {
			Thread.sleep(120000);
		} catch (InterruptedException e){
			System.err.println(e);
		}
	}
	
	@Override
	public void run() {

		// @todo Lire le moyen de paiment de la voiture
		paiement();
		
		envoyerRapport();
		leverBarriere();

		_vehicule.quitterPeage();
		long tmp = _vehicule.getTempsPassage();
		calculerTmpMoyen(tmp);
		_vehicule = null;
	}*/
}
