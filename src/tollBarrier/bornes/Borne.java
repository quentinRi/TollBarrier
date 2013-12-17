package tollBarrier.bornes;

import java.util.Set;

import tollBarrier.barrier.TollBarrier;
import tollBarrier.vehicule.*;

/**
 * 
 * @todo calculerTmpMoyen et faire le lien avec la barriere
 * 
 */

public abstract class Borne extends Thread
{
	protected Set<MoyenDePaiment>	_payment;
	protected boolean				_boutonUrgence	= false;
	protected boolean				_vehAutorise	= true;
	protected boolean				_paymentAccepte	= false;
	protected boolean				_barriereLevee	= false;
	protected boolean				_vehAval		= false;
	protected boolean				_vehAmont		= false;
	private long					nbVeh;
	private long					time;
	private double					tmpMoyen;
	private Vehicule				vehicule;
	private int						num;
	private static int				nbInstance		= 0;

	public Borne()
	{
		num = nbInstance;
		nbInstance ++;
	}

	public void leverBarriere()
	{

	}

	public void envoyerRapport()
	{

	}

	public boolean demanderAccord()
	{

		return false;
	}

	private void calculerTmpMoyen(long tmp)
	{

	}

	public double getTempsPassageMoyen()
	{

		return tmpMoyen;
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
				nbVeh++;
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
		return _payment;
	}

	/**
	 * @param remove
	 */
	public void setVehicule(Vehicule remove)
	{
		vehicule = remove;
	}
	
	public String toString()
	{
		return ""+num;
	}

}
