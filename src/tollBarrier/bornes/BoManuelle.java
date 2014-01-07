package tollBarrier.bornes;
import java.util.HashSet;

import tollBarrier.vehicule.MoyenDePaiment;

import java.util.ArrayList;

import tollBarrier.vehicule.MoyenDePaiment;

public class BoManuelle extends Borne{

	
	public BoManuelle(){

		super();
		_paiement = new HashSet<MoyenDePaiment>();
		_paiement.add(MoyenDePaiment.CB);
		_paiement.add(MoyenDePaiment.Liquide);
		_paiement.add(MoyenDePaiment.Abonnement);
	}
	
	
	public void envoyerRapport(){
		
		
	}

	public void paiment(MoyenDePaiment m){
		
		switch(m){
		
		case CB :
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e){
				System.err.println(e);
			}
		case Liquide :
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e){
				System.err.println(e);
			}
		case Abonnement :
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e){
				System.err.println(e);
			}
		}
	}
	
	@Override
	public void run() {

		// @todo Lire le moyen de paiment de la voiture
		_vehicule.getMoyensDePaiment()
		paiment(m);
		
		envoyerRapport();
		leverBarriere();

		_vehicule.quitterPeage();
		long tmp = _vehicule.getTempsPassage();
		calculerTmpMoyen(tmp);
		_vehicule = null;
	}
	
}
