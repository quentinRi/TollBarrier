package tollBarrier.bornes;
import java.util.ArrayList;
import tollBarrier.vehicule.MoyenDePaiment;

public abstract class Borne {

	protected ArrayList<MoyenDePaiment> _payment;
	protected boolean _boutonUrgence = false;
	protected boolean _vehAutorise = true;
	protected boolean _paymentAccepte = false;
	protected boolean _barriereLevee = false;
	protected boolean _vehAval = false;
	protected boolean _vehAmont = false;
	
	public Borne(){}
	
	public void leverBarriere(){
		
	}
	
	public void envoyerRapport(){
		
	}
	
	public boolean demanderAccord(){
		
		return false;
	}
	
	public int getTempsPassageMoyen(){
		
	}
	
}
