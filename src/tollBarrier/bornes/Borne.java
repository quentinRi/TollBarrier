package tollBarrier.bornes;

import java.util.Set;

import tollBarrier.barrier.TollBarrier;
import tollBarrier.vehicule.*;
import tollBarrier.vehicule.exceptions.NotGoneVehiculeException;
import tollBarrier.vehicule.exceptions.PasDeVehiculeTrouveException;
import tollBarrier.vehicule.vehiculesObjects.Vehicule;

/**
 * 
 * @todo calculerTmpMoyen et faire le lien avec la barriere
 * 
 * 
 * 
 */

public abstract class Borne extends Thread
{
	protected Set<MoyenDePaiment> _paiement;
	protected boolean _boutonUrgence = false;
	protected boolean _vehAutorise = true;
	protected boolean _paymentAccepte = false;
	protected boolean _barriereLevee = false;
	protected boolean _vehAval = false;
	protected boolean _vehAmont = false;
	protected long _nbVeh;
	protected Vehicule _vehicule;
	private long _time;
	private int num;
	private static int nbInstance = 0;

	public Borne()
	{
		num = nbInstance;
		nbInstance++;
		_vehicule = null;
		_nbVeh = 0;
	}

	public long leverBarriere()
	{
		_paymentAccepte = demanderAccord();
		long tempsPassage = 0;
		if (!_paymentAccepte)
		{
			alarme();// TODO Implémenter les différentes alarmes
		}
		System.out.println(_vehicule + " est passé à la borne " + num);
		_vehicule.quitterPeage();
		try
		{
			tempsPassage = _vehicule.getTime();
		} catch (NotGoneVehiculeException e)
		{
			e.printStackTrace();
		}
		_vehicule = null;
		return tempsPassage;
	}

	public boolean demanderAccord()
	{
		return true;
	}

	public void alarme()
	{
		try
		{
			Thread.sleep(12000);
		} catch (InterruptedException e)
		{
			System.err.println(e);
		}
	}

	public void run()
	{
		while (TollBarrier.isRunning())
		{
			try
			{
				_vehicule = TollBarrier.getInstance().getVehicule(this);
			} catch (PasDeVehiculeTrouveException pasDeVeh)
			{
				try
				{
					Thread.sleep(100);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				continue;
			}

			try
			{
				System.out.println(_vehicule + " arrive à la borne " + num);
				_vehicule.rejoindreFile();
				payer();
				long timePassed = leverBarriere();
				envoyerRapport(timePassed);
			} catch (Exception e)
			{
				e.printStackTrace();
			}

		}
	}

	private void payer()
	{
		MoyenDePaiment mdp = null;

		for (MoyenDePaiment obj : _vehicule.getMoyensDePaiment())
		{
			if (_paiement.contains(obj))
			{
				mdp = obj;
				break;
			}
		}
		long time = 500 * _vehicule.getTimeMuliplier()
				* mdp.getTimeMultiplier();
		try
		{
			Thread.sleep(time);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	public Set<MoyenDePaiment> getMoyensDePaiment()
	{
		return _paiement;
	}

	public void envoyerRapport(long time) throws NotGoneVehiculeException
	{
		_nbVeh++;
		_time += time;
		System.out.println(time + " " + _nbVeh);
		TollBarrier.getInstance().envoyerRapport();
	}

	public String toString()
	{
		return "" + num + " de type " + getType();
	}

	public double getTempsPassageMoyen()
	{
		if (_time == 0)
			return -1;
		return _time / _nbVeh;
	}
	
	public long getNbVeh()
	{
		return _nbVeh;
	}

	public Set<MoyenDePaiment> getMoyenDePaiment()
	{

		return _paiement;
	}

	public abstract String getType();

	public double getTime()
	{
		return _time;
	}

}
