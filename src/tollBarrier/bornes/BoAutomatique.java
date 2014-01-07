package tollBarrier.bornes;
import java.util.HashSet;

import tollBarrier.vehicule.MoyenDePaiment;

public class BoAutomatique extends Borne{

	
	public BoAutomatique(){

		super();
		_paiement = new HashSet<MoyenDePaiment>();
		_paiement.add(MoyenDePaiment.CB);
		_paiement.add(MoyenDePaiment.Liquide);
		_paiement.add(MoyenDePaiment.Abonnement);
	}
	
/*
	public void envoyerRapport(){
		
	}
*/
	public void paiment(MoyenDePaiment m){
		
		switch(m){
		
		case CB :
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		case Liquide :
			try {
				Thread.sleep(11000);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		case Abonnement :
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
	}
	
	@Override
	public void run() {

		// @todo Lire le moyen de paiment de la voiture
		paiment(MoyenDePaiment.CB);
		
		envoyerRapport();
		leverBarriere();

		_vehicule.quitterPeage();
		long tmp = _vehicule.getTempsPassage();
		calculerTmpMoyen(tmp);
		_vehicule = null;
	}

	
}
