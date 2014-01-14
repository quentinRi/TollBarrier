package tollBarrier.bornes;
import java.util.HashSet;

import tollBarrier.vehicule.MoyenDePaiment;


public class BoManuelle extends Borne{

	
	public BoManuelle(){

		super();
		_paiement = new HashSet<MoyenDePaiment>();
		_paiement.add(MoyenDePaiment.CB);
		_paiement.add(MoyenDePaiment.LIQUIDE);
		_paiement.add(MoyenDePaiment.ABONNEMENT);
	}
	/*
	public void paiement(MoyenDePaiment m){
		
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
		Set<MoyenDePaiment> mdp = _vehicule.getMoyensDePaiment();
		Iterator<MoyenDePaiment> It = mdp.iterator();
		MoyenDePaiment m = It.next();
		boolean paiementEffectue = false;
		do{
			if(_paiement.contains(m)){
				paiement(m);
				paiementEffectue = true;
			}
		}while(It.hasNext() && paiementEffectue == false);
		if(!paiementEffectue){
			alarme();
		}
		
		envoyerRapport();
		leverBarriere();

		_vehicule.quitterPeage();
		long tmp = _vehicule.getTempsPassage();
		calculerTmpMoyen(tmp);
		_vehicule = null;
	}
	*/

}
