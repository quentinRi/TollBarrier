package tollBarrier.vehicule;

import java.util.ArrayList;

public class FileDAttente {

	private ArrayList<Vehicule> file;
	
	public FileDAttente () {
		file = new ArrayList<Vehicule>();
	}
	
	public void ajouterVehicule (Vehicule v) {
		file.add(v);
	}
	
	public Vehicule transfererVehicule (Borne borne) {
		
	}
}



/**
 * @todo :
 * 	récupéer collection de moyen de paiùment de la borne
 * itérer sur la file
 * si moyen de paiment du vehicule in collection return ce vehicule
 * fin itération
 * throw exception
 */
