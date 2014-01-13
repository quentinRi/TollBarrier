package tollBarrier.vehicule.vehiculesObjects;

import java.util.Set;

import tollBarrier.vehicule.MoyenDePaiment;
import tollBarrier.vehicule.exceptions.NotGoneVehiculeException;

public abstract class Vehicule
{

	private Set<MoyenDePaiment>	_mdp;
	private long				_hDebut;
	private long				_hFin;
	private static int			instanceNumber	= 0;
	private int					num;

	public Vehicule(Set<MoyenDePaiment> mdp)
	{
		_hDebut = 0;
		_hFin = 0;
		_mdp = mdp;
		num = instanceNumber;
		instanceNumber++;
	}

	public void rejoindreFile()
	{
		_hDebut = System.currentTimeMillis()/1000;
	}

	public void quitterPeage()
	{
		_hFin = System.currentTimeMillis()/1000;
	}

	public Set<MoyenDePaiment> getMoyensDePaiment()
	{
		return _mdp;
	}

	public abstract long getTimeMuliplier();

	public String toString()
	{
		String s = "";
		s+= getClass().getSimpleName();
		s+= " n°"+num;
		return s;
	}

	public long getTime() throws NotGoneVehiculeException
	{
		if (_hDebut == 0 || _hFin == 0)
			throw new NotGoneVehiculeException();
		return _hFin - _hDebut;
	}
}
