package tollBarrier.bornes;

import java.util.Set;

import tollBarrier.barrier.TollBarrier;
import tollBarrier.vehicule.*;

/**
 * 
 * @todo calculerTmpMoyen et faire le lien avec la barriere
 * 
 * 
 * 
 */

public abstract class Borne // extends Thread
{
	protected Set<MoyenDePaiment> _paiement;
	protected boolean _boutonUrgence = false;
	protected boolean _vehAutorise = true;
	protected boolean _paymentAccepte = false;
	protected boolean _barriereLevee = false;
	protected boolean _vehAval = false;
	protected boolean _vehAmont = false;
	protected long _nbVeh;
	protected double _tmpMoyen;
	protected Vehicule _vehicule;
	private long time;
	private Vehicule vehicule;
	private int num;
	private static int nbInstance = 0;

	public Borne()
	{
		num = nbInstance;
		nbInstance++;
		_vehicule = null;
		_tmpMoyen = 0;
		_nbVeh = 0;
	}

	public void arriveeVehicule(Vehicule V)
	{

		_vehicule = V;
		_nbVeh++;
	}

	public void leverBarriere()
	{

		_paymentAccepte = demanderAccord();
		if (_paymentAccepte)
			_barriereLevee = true;
	}

	public boolean demanderAccord()
	{

		return true;
	}

	public void run()
	{
		while (true)
		{
			try
			{
				TollBarrier.getInstance().getVehicule(this);
				if (vehicule == null)
				{
					continue;
				}
				long time = vehicule.getTime();
				try
				{
					Thread.sleep(time);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				_nbVeh++;
				this.time += time;
				System.out.println(vehicule + " est passé à la borne " + num);
				vehicule = null;
			} catch (PasDeVehiculeTrouveException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return
	 */
	public Set<MoyenDePaiment> getMoyensDePaiment()
	{
		return _paiement;
	}

	/**
	 * @param remove
	 */
	public void setVehicule(Vehicule remove)
	{
		vehicule = remove;
	}

	public void envoyerRapport()
	{
	}

	protected void calculerTmpMoyen(long tmp)
	{

		_tmpMoyen = (_tmpMoyen * (_nbVeh - 1) + tmp) / _nbVeh;
	}

	public String toString()
	{
		return "" + num;
	}

	public double getTempsPassageMoyen()
	{

		return _tmpMoyen;
	}

	public Set<MoyenDePaiment> getMoyenDePaiment()
	{

		return _paiement;
	}

}
