package tollBarrier.vehicule;

import java.util.Set;

public abstract class Vehicule {

	private Set<MoyenDePaiment> _mdp;
	private long _hDebut;
	private long _hFin;
	
	public Vehicule (Set<MoyenDePaiment> mdp) {
		_hDebut = 0;
		_hFin = 0;
		_mdp = mdp;
		
	}
	
	public void rejoindreFile (FileDAttente file) {
		_hDebut = System.currentTimeMillis();
	}
	
	public void quitterPeage () {
		_hFin = System.currentTimeMillis();
	}
	
	public long getTempsPassage () {
		return _hFin - _hDebut; 
	}
	
	public Set<MoyenDePaiment> getMoyensDePaiment() {
		return _mdp;
	}
}
