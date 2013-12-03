package tollBarrier.vehicule;

public class FabriqueDeVehicule {

	public FabriqueDeVehicule () {
		
	}
	
	public Vehicule creerVehicule (String type) {
				
		switch (type) {
			case "Camion": return new Camion();
			case "DeuxRoues": return new DeuxRoues ();
			case "Voiture" : return new Voiture ();
			default : return null;
		}		
	}
}
