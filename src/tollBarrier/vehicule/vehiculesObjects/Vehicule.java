package tollBarrier.vehicule.vehiculesObjects;

import java.util.Set;

import tollBarrier.vehicule.MoyenDePaiment;
import tollBarrier.vehicule.exceptions.NotGoneVehiculeException;

public abstract class Vehicule
{

	private Set<MoyenDePaiment> _mdp;
	private long _hDebut;
	private long _hFin;
	private static int instanceNumber = 0;
	private int num;
	private long _hArriveBorne;

	public Vehicule(Set<MoyenDePaiment> mdp)
	{
		_hDebut = System.currentTimeMillis() / 1000;
		_hArriveBorne = 0;
		_hFin = 0;
		_mdp = mdp;
		num = instanceNumber;
		instanceNumber++;
	}

	public void rejoindreFile()
	{
		_hArriveBorne = System.currentTimeMillis() / 1000;
	}

	public void quitterPeage()
	{
		_hFin = System.currentTimeMillis() / 1000;
	}

	public Set<MoyenDePaiment> getMoyensDePaiment()
	{
		return _mdp;
	}

	public abstract long getTimeMuliplier();

	public String toString()
	{
		String s = "";
		s += getClass().getSimpleName();
		s += " n°" + num;
		return s;
	}
	
	public long getTimeAtBorne()  throws NotGoneVehiculeException
	{
		if (_hArriveBorne == 0 || _hFin == 0)
			throw new NotGoneVehiculeException();
		return _hFin - _hArriveBorne;
	}
	
	public long getTimeWaiting()  throws NotGoneVehiculeException
	{
		if (_hArriveBorne == 0 || _hFin == 0)
			throw new NotGoneVehiculeException();
		return _hArriveBorne - _hDebut;
	}

	public long getTime() throws NotGoneVehiculeException
	{
		if (_hFin == 0)
			throw new NotGoneVehiculeException();
		return _hFin - _hDebut;
	}
}
