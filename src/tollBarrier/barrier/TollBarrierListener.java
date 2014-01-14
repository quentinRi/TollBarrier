
package tollBarrier.barrier;

public interface TollBarrierListener
{
	void updateVehiculesEnAttente();
	void updateTempsPassageMoyen();
	void updateArgentEncaisse();
	void updateArgentEncaisseMoyen();
	void updateNombreAlarmes();
	void updateBornes();

	void startRunning();
	void stopRunning();
	
	void updateAll();

}
