package tollBarrier.bornes;

import java.util.Set;

import tollBarrier.barrier.TollBarrier;
import tollBarrier.vehicule.*;
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
	private long time;
	private int num;
	private static int nbInstance = 0;

	public Borne()
	{
		num = nbInstance;
		nbInstance++;
		_vehicule = null;
		_nbVeh = 0;
	}

	/*
	 * public void arriveeVehicule(Vehicule V){
	 * 
	 * if(_vehicule == null){ _vehicule = V; _nbVeh++; }
	 */

	public void leverBarriere()
	{
		_paymentAccepte = demanderAccord();
		if (_paymentAccepte)
		{
			System.out.println(_vehicule + " est passé à la borne " + num);
			_vehicule.quitterPeage();
			_vehicule = null;
		}
	}

	public boolean demanderAccord()
	{

		return true;
	}

	public void alarme()
	{
	}

	public void run()
	{
		while (true)
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

			System.out.println(_vehicule + " arrive à la borne " + num);
			try
			{
				Thread.sleep(_vehicule.getTime());
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			envoyerRapport();
			leverBarriere();

		}
	}

	/**
	 * @return
	 */
	public Set<MoyenDePaiment> getMoyensDePaiment()
	{
		return _paiement;
	}

	public void envoyerRapport()
	{
		_nbVeh++;
		this.time += _vehicule.getTime();
	}

	public String toString()
	{
		return "" + num;
	}

	public double getTempsPassageMoyen()
	{

		return time / _nbVeh;
	}

	public Set<MoyenDePaiment> getMoyenDePaiment()
	{

		return _paiement;
	}

}
