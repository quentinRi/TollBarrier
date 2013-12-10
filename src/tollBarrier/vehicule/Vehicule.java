package tollBarrier.vehicule;

import java.util.ArrayList;

public abstract class Vehicule {

	private ArrayList<MoyenDePaiment> mdp;
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
	
	public ArrayList<MoyenDePaiment> getMoyensDePaiment() {
		return mdp;
	}
}
