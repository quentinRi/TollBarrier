package tollBarrier.bornes;
import java.util.Set;
import tollBarrier.vehicule.*;
/**
 * 
 * 
 *
 */

public abstract class Borne extends Thread{

	protected Set<MoyenDePaiment> _paiement;
	protected boolean _boutonUrgence = false;
	protected boolean _vehAutorise = true;
	protected boolean _paymentAccepte = false;
	protected boolean _barriereLevee = false;
	protected boolean _vehAval = false;
	protected boolean _vehAmont = false;
	protected long _nbVeh;
	protected double _tmpMoyen;
	protected Vehicule _vehicule;
	
	public Borne(){
		
		_vehicule = null;
		_tmpMoyen = 0;
		_nbVeh = 0;
	}
	
	public void arriveeVehicule(Vehicule V){
		
		_vehicule = V;
		_nbVeh++;
	}
	
	public void leverBarriere(){
		
		_paymentAccepte = demanderAccord();
		if(_paymentAccepte)
			_barriereLevee = true;
	}
	
	public boolean demanderAccord(){
		
		return true;
	}
	
	public void envoyerRapport(){}
	
	protected void calculerTmpMoyen(long tmp){
		
		_tmpMoyen = (_tmpMoyen*(_nbVeh-1) + tmp)/_nbVeh;
	}
	
	public double getTempsPassageMoyen(){
		
		return _tmpMoyen;
	}
	
	public Set<MoyenDePaiment> getMoyenDePaiment(){
	
		return _paiement;
	}
		
}
