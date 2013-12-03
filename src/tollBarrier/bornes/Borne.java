package tollBarrier.bornes;

public abstract class Borne {

	private Array<MoyenDePaiment> _payment;
	private boolean _boutonUrgence = false;
	private boolean _vehAutorise = true;
	private boolean _paymentAccepte = false;
	private boolean _barriereLevee = false;
	private boolean _vehAval = false;
	private boolean _vehAmont = false;
	private int _numBorne;
	
	public Borne(int numBorne){

		_numBorne = numBorne;
	}
	
	public void leverBarriere(){
		
	}
	
	public void envoyerRapport(){
		
	}
	
	public boolean demanderAccord(){
		
	}
	
	public void envoyerAlarme(){
		
	}
}
