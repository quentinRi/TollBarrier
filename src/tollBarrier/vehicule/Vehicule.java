package tollBarrier.vehicule;

import java.util.Set;

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
		_hDebut = System.currentTimeMillis();
	}

	public void quitterPeage()
	{
		_hFin = System.currentTimeMillis();
	}

	public long getTempsPassage()
	{
		return _hFin - _hDebut;
	}

	public Set<MoyenDePaiment> getMoyensDePaiment()
	{
		return _mdp;
	}

	public abstract long getTime();

	public String toString()
	{
		String s = "";
		s+= getClass().getSimpleName();
		s+= " n°"+num;
		return s;
	}
}
