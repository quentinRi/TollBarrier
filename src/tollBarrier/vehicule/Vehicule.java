package tollBarrier.vehicule;

public abstract class Vehicule {

	private MoyenDePaiment mdp [];
	private long hDebut;
	private long hFin;
	
	public Vehicule () {
		hDebut = 0;
		hFin = 0;
	}
	
	public void rejoindreFile (FileDAttente file) {
		hDebut = System.currentTimeMillis();
	}
	
	public void quitterPeage () {
		hFin = System.currentTimeMillis();
	}
	
	public long getTempsPassage () {
		return hFin - hDebut; 
	}
	
}
