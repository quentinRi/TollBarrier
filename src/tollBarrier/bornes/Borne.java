package tollBarrier.bornes;

import java.util.Random;
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
	private long _argent;
	private int _acc;
	private boolean _accFlag;
	private int _alarmeRate;
	private int _nbAlarme;
	private boolean stop = false;

	public void stopIt()
	{
		stop = true;
	}

	public Borne()
	{
		num = nbInstance;
		nbInstance++;
		_vehicule = null;
		_nbVeh = 0;
		_argent = 0;
		_acc = 1;
		_accFlag = false;
		_alarmeRate = 1000;
		_nbAlarme = 0;
	}

	public void setAlarmeRate(int n)
	{
		_alarmeRate = n;
	}

	public long leverBarriere()
	{
		_paymentAccepte = demanderAccord();
		long tempsPassage = 0;
		if (!_paymentAccepte)
		{
			alarme();
		}
		System.out.println(_vehicule + " est pass� � la borne " + num);
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

	public void accelerate()
	{

		_accFlag = !_accFlag;
	}

	public boolean demanderAccord()
	{
		Random R = new Random();
		int n = R.nextInt(_alarmeRate);
		if (n == 0)
			return false;
		return true;
	}

	public int getNbAlarme()
	{
		return _nbAlarme;
	}

	public void alarme()
	{
		_nbAlarme++;
		Random R = new Random();
		int n = R.nextInt(10);
		int time = 12000;
		if (n == 1)
			time += 108000;
		try
		{
			if (_accFlag)
				time = time / 10;
			Thread.sleep(time);
		} catch (InterruptedException e)
		{
			System.err.println(e);
		}
	}

	public void run()
	{
		while (TollBarrier.isRunning() && !stop)
		{
			try
			{
				_vehicule = TollBarrier.getInstance().getVehicule(this);
			} catch (PasDeVehiculeTrouveException pasDeVeh)
			{
				try
				{
					if (_accFlag)
						Thread.sleep(10);
					else
						Thread.sleep(100);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				continue;
			}

			try
			{
				System.out.println(_vehicule + " arrive � la borne " + num);
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

		_argent += _vehicule.getMontantPaiment();

		long time = 500 * _vehicule.getTimeMuliplier()
				* mdp.getTimeMultiplier() + additionalTime();
		try
		{
			if (_accFlag)
				time = time / 10;
			Thread.sleep(time);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	protected abstract int additionalTime();

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

	public long getArgentEncaisse()
	{
		return _argent;
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
