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
	public void arriveeVehicule(Vehicule V){
		
		if(_vehicule == null){
			_vehicule = V;
			_nbVeh++;
		}
*/

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
	
	public void alarme(){}
		
	public void run()
	{
		while (true)
		{
			try
			{
				TollBarrier.getInstance().getVehicule(this);
				if (_vehicule == null)
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
				long time = _vehicule.getTime();
				try
				{
					Thread.sleep(time);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				_nbVeh++;
				this.time += time;
				envoyerRapport();
				leverBarriere();
				_vehicule.quitterPeage();
				System.out.println(_vehicule + " est passé à la borne " + num);
				_vehicule = null;

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
		_vehicule = remove;
	}

	public void envoyerRapport()
	{
	}

	public String toString()
	{
		return "" + num;
	}

	public double getTempsPassageMoyen()
	{

		return time/_nbVeh;
	}

	public Set<MoyenDePaiment> getMoyenDePaiment()
	{

		return _paiement;
	}

}
