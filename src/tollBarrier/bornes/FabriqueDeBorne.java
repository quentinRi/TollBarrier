package tollBarrier.bornes;

public class FabriqueDeBorne {

	public FabriqueDeBorne(){
		
	}
	
	public Borne creerBorne(String type){
		
		switch (type){
			case "Manuelle": return new BoManuelle();
			case "Telepeage": return new BoTelePeage();
			case "Automatique": return new BoAutomatique();
			default: return null;
		
		}
	}
}
