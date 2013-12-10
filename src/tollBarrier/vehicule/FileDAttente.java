package tollBarrier.vehicule;

import java.util.ArrayList;
import java.util.Collection;

import tollBarrier.bornes.Borne;

public class FileDAttente {

	private ArrayList<Vehicule> file;
	
	public FileDAttente () {
		file = new ArrayList<Vehicule>();
	}
	
	public void ajouterVehicule (Vehicule v) {
		file.add(v);
	}
	
	public Vehicule recupererVehicule (Borne borne) throws PasDeVehiculeTrouveException {
		
		// Recupération des moyens de paiement acceptés par la borne demandeuse de véhicule
		ArrayList<MoyenDePaiment> bmdp = borne.getMoyensDePaiment();
		
		// Pour chaque véhicule dans la file
		for (int i = 0; i < file.size(); i++) {
			
			// On récupère ses moyens de paiement possibles
			ArrayList<MoyenDePaiment> vmdp = file.get(i).getMoyensDePaiment();
			
			// On vérifie si ce véhicule peut aller dans la borne demandeuse
			for (int j = 0; j < vmdp.size(); j++)				
				
				// Si le véhicule correpsond, on l'envoie à la borne
				if (bmdp.contains(vmdp.get(i))) {
					Vehicule v = file.get(i);
					file.remove(i);
					return v;
				}
		}
		
		// Si aucun véhicule dans la file ne correspond, on renvoie une exception
		String s = "Pas de Véhicule ac mdp: ";
		for(int i=0; i<bmdp.size(); i++)
			s += bmdp.get(i) + " ";
		
		throw new PasDeVehiculeTrouveException(s);
	}
}
